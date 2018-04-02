package com.netapp.ads.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.ActivityResponse;
import com.netapp.ads.models.Host;
import com.netapp.ads.models.LineOfBusiness;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.QtreeDisposition;
import com.netapp.ads.models.Share;
import com.netapp.ads.models.UserCorporate;
import com.netapp.ads.models.verum.application.Contact;
import com.netapp.ads.models.verum.application.OSI;
import com.netapp.ads.models.verum.application.VerumObjectList;
import com.netapp.ads.models.verum.esource.EmployeeList;
import com.netapp.ads.models.verum.esource.EmployeeProfile;
import com.netapp.ads.models.verum.person.Person;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.repos.ActivityResponseRepository;
import com.netapp.ads.repos.ApplicationRepository;
import com.netapp.ads.repos.HostRepository;
import com.netapp.ads.repos.LineOfBusinessRepository;
import com.netapp.ads.repos.QtreeDispositionRepository;
import com.netapp.ads.repos.UserCorporateRepository;
import com.netapp.ads.repos.UserRoleRepository;

@Service
public class OwnerIdentificationService {
	
	private Logger log = LoggerFactory.getLogger(OwnerIdentificationService.class);
	
	@Value("${ads.rule.discovery_rule.disposition}")
	public String discoveryDisposition;
	
	@Autowired
	public ActivityRepository activityRepository;
	
	@Autowired
	public ActivityResponseRepository activityResponseRepository;
	
	@Autowired
	public HostRepository hostRepository;	
	
	@Autowired
	ApplicationService applicationService;
	
	@Autowired
	QtreeDispositionRepository qtreeDispositionRepository;
	
	@Autowired
	public ApplicationRepository applicationRepository;
	
	@Autowired
	public UserCorporateRepository userCorporateRepository;
	
	@Autowired
	public UserRoleRepository userRoleRepository;	
	
	@Autowired
	public LineOfBusinessRepository lineOfBusinessRepository;	
	
	/**
	 * Finds activities where owner needs to be discovered
	 * For each activity creates Applications and corresponding Corporate Users obtained from CMDB based on IP Address of
	 * the host. Activity -> Qtree -> Share --> Host -> Applications and Corporate Users
	 * For each application it also creates an initial Activity Response for a user - one activity response per activity per user
	 * It also sets in activity.note whether the activity is single owner or multi however this is not needed since we can
	 * easily generate a count of activity responses to determine that - if activity response count > 1, then it is a 
	 * multi-owner situation
	 * 
	 */
	public void identifyOwner() {
		log.debug("identifyOwner(): [ENTER] ");
		
		List<QtreeDisposition> qtreeDispositions = qtreeDispositionRepository.findByDisposition(discoveryDisposition);
		log.debug("identifyOwner(): qtreeDispositions: {}", qtreeDispositions.size());
		for(QtreeDisposition qtreeDisposition: qtreeDispositions) {
			log.debug("identifyOwner(): qtreeDisposition: {}", qtreeDisposition.getId());
			Qtree qtree = qtreeDisposition.getQtree();
			log.debug("identifyOwner(): qtree: " + qtree.getId());
			Activity activity = qtree.getActivity();
			List<Share> shares = qtree.getShares();
			log.debug("identifyOwner(): shares: " + shares.size());
			for(Share share: shares) {
				Host host = share.getHost();
				log.debug("identifyOwner(): share: {}, host: {}, host owner: {} ", share.getId(), host.getId(), host.getHostOwnerUserCorporateId());
				processHost(host, activity);
			}
		} //end of for
			
		log.debug("identifyOwner(): [EXIT]");
	}
	
	public void processHost(Host host, Activity activity) {
		if( isIdEmpty(host.getHostOwnerUserCorporateId()) ) {
			log.debug("identifyOwner(): No corporate ID on host so going through applications");
			
			//Based on the hosts IP Addresses call CMDB to fetch applications and corresponding corporate owner users
			//then for each corporate user create an activity response which will assist in owner identification
			createApplicationUsersAndActivityResponses(host, activity);
			
			updateHostAsPerActivity(host, activity);
		} //end if for host check 
		else {
			log.debug("identifyOwner(): Duplicate Host {} owner: associated with IP:{}", host.getHostOwnerUserCorporateId(), host.getIpAddr());
		
			//if activity does not have owner or activities owner ID is samee as hosts owner ID and activity is SINGLE then
			List<ActivityResponse> activityResponses = activity.getActivityResponses();
			if(
				activityResponses.isEmpty() || 
				(activityResponses.size() == 1 && activityResponses.get(0).getOwnerUserCorporateId().intValue() == host.getHostOwnerUserCorporateId() && activity.getNote().equals(QtreeOwnerStatus.Single.name()))
			) {
				//ADD LOGIC FOR LOB
				if(host.getNote().equals(QtreeOwnerStatus.Multi.name())) {
					activity.setNote(QtreeOwnerStatus.Multi.name());
				} else {
					activity.setNote(QtreeOwnerStatus.Single.name());
				}
			} else {
				createActivityResponse(activity, activityResponses, host.getHostOwnerUserCorporate());
			} // else
		} //main else for host
	}
	
	public List<com.netapp.ads.models.Application> createApplicationUsersAndActivityResponses(Host host, Activity activity) {
		String ipAddress = host.getIpAddr();
		log.debug("createApplicationAndUsers(): [ENTERED]: ipAddress: " + ipAddress);
		OSI osi = applicationService.getVerumApp(ipAddress);
		List<com.netapp.ads.models.Application> applications = new ArrayList<>();
		if(osi != null) {
			List<VerumObjectList> verumObjectLists = osi.getVerumObjectList();
			for (VerumObjectList verumObjectList : verumObjectLists) {
				List<com.netapp.ads.models.verum.application.Application> verumApplications = verumObjectList.getApplication();
				for(com.netapp.ads.models.verum.application.Application verumApplication : verumApplications) {
					com.netapp.ads.models.Application application = applicationRepository.findByApplicationCode(verumApplication.getAppID());
					List<Contact> contacts = verumApplication.getContact();
					//if application is null - create ar, user, application
					//if application is not null and admin override - create ar, user
					if(application == null) {
						checkActivityResponses(activity, contacts);
						LineOfBusiness lob = getOrCreateLob(verumApplication.getOwningLOB());
						log.debug("createApplicationAndUsers(): Application DOES NOT exist. Creating.." );
						application = new com.netapp.ads.models.Application();
						if(!application.getHosts().contains(host)) {
							application.addHost(host);
						}
						application.setApplicationName(verumApplication.getApplicationName());
						application.setApplicationCode(verumApplication.getAppID());
						//FIXME: THERE ARE MULTIPLE CONTACTS. But application has only 1 owner
						application.setOwnerUserCorporateId(getOrCreateCorporateUser(contacts.get(0).getSid()).getId());
						//FIXME: application.setArchtype(verumApplication.get); WHERE TO GET THIS FROM?
						application.setInformationOwner(verumApplication.getTechGroupOwner()); //IS THIS CORRECT?
						application.addLineOfBusinesses(lob);
						application = applicationRepository.save(application);
						
						activity.addLineOfBusinesses(lob);
						activityRepository.save(activity);
						log.debug("createApplicationAndUsers(): Application Created/Updated: " + application.getId());
					} else {
						if(activity.getAdminOverride()) {
							checkActivityResponses(activity, contacts);
						}
						log.debug("createApplicationAndUsers(): Application already exists: " + application.getId());
					}
					applications.add(application);
				}
			}
		}
		log.debug("createApplicationAndUsers(): [EXIT]");
		return applications;
	}
	
	public void checkActivityResponses(Activity activity, List<Contact> contacts) {
		List<ActivityResponse> activityResponses = activity.getActivityResponses();
		for(Contact contact: contacts) {
			UserCorporate corporateUser = getOrCreateCorporateUser(contact.getSid());
			if(corporateUser != null) {
				log.error("User to add to activity response!:" + corporateUser.getLastName());
				createActivityResponse(activity, activityResponses, corporateUser);
			} else {
				log.error("No User to add to activity response!");
			}
		}
	}
	
	public LineOfBusiness getOrCreateLob(String lobName) {
		LineOfBusiness lob = lineOfBusinessRepository.findByLobName(lobName);
		if(lob == null) {
			lob = new LineOfBusiness();
			lob.setLobName(lobName);
			//FIXME: Where do we get these other lob details from? MMS did not use it
			lob.setLiasonFirstName("DUMMY");
			lob.setLiasonContactNumber("DUMMY");
			lob.setLiasonEmail("DUMMY");
			lob.setLiasonLastName("DUMMY");
			lob.setLiasonUserName("DUMMY");
			lineOfBusinessRepository.save(lob);
		}
		return lob;
	}
	
	public UserCorporate getOrCreateCorporateUser(String sid) {
		log.debug("getOrCreateCorporateUser: sid: " + sid);
		UserCorporate corporateUser = null;
		Person person = applicationService.getVerumPerson(sid);
		if(person != null && !person.getVerumObjectList().isEmpty()) {
			List<com.netapp.ads.models.verum.person.VerumObjectList> personVerumObjectLists = person.getVerumObjectList();
			com.netapp.ads.models.verum.person.VerumObjectList personVerumObjectList = personVerumObjectLists.get(0);
			UserCorporate manager = userCorporateRepository.findFirstByUserName(personVerumObjectList.getManagerSid());
			if(manager == null) {
				log.debug("getOrCreateCorporateUser(): Manager does not exist");
				EmployeeProfile managerProfile = applicationService.getEmployeeProfile(personVerumObjectList.getManagerSid());
				if(managerProfile != null && !managerProfile.getEmployeeList().isEmpty()) {
					EmployeeList managerEmployee = managerProfile.getEmployeeList().get(0);
					manager = new UserCorporate();
					manager.setUserName(personVerumObjectList.getManagerSid());
					manager.setFirstName(managerEmployee.getFirstName());
					manager.setLastName(managerEmployee.getLastName());
					manager.setMiddleName(managerEmployee.getMiddle());
					manager.setUserRole(userRoleRepository.findOneByUserRole("ROLE_USER"));
					manager.setEmail(managerEmployee.getIAddress());
					manager.setBestPhone(managerEmployee.getPhoneNo());
					manager.setMobilePhone(managerEmployee.getCellPhoneNo());
					manager.setTitle(managerEmployee.getTitle());
					manager.setLocation(managerEmployee.getBuildStreetAddress() + "," + managerEmployee.getBuildState() + "," + managerEmployee.getBuildZip() + "," + managerEmployee.getBuildCountry());
					userCorporateRepository.save(manager);
				}
			}

			corporateUser = userCorporateRepository.findFirstByUserName(sid);
			if(corporateUser == null) {
				log.debug("getOrCreateCorporateUser(): Corporate user DOES NOT exist. Creating....");
				corporateUser = new UserCorporate();
				corporateUser.setCostCenter(personVerumObjectList.getCostCenter());
				corporateUser.setUserName(sid);
				corporateUser.setUserCorporateManager(manager);
				
				EmployeeProfile employeeProfile = applicationService.getEmployeeProfile(sid);
				if(employeeProfile != null && !employeeProfile.getEmployeeList().isEmpty()) {
					//We are getting a targeted user here based on SID so this list should always have 1 value
					EmployeeList employee = employeeProfile.getEmployeeList().get(0);
					corporateUser.setFirstName(employee.getFirstName());
					corporateUser.setLastName(employee.getLastName());
					corporateUser.setMiddleName(employee.getMiddle());
					corporateUser.setUserRole(userRoleRepository.findOneByUserRole("ROLE_USER"));
					corporateUser.setEmail(employee.getIAddress());
					corporateUser.setBestPhone(employee.getPhoneNo());
					corporateUser.setMobilePhone(employee.getCellPhoneNo());
					corporateUser.setTitle(employee.getTitle());
					corporateUser.setLocation(employee.getBuildStreetAddress() + "," + employee.getBuildState() + "," + employee.getBuildZip() + "," + employee.getBuildCountry());
					corporateUser = userCorporateRepository.save(corporateUser);
					log.debug("getOrCreateCorporateUser(): Created/Updated Corporate User: " + corporateUser.getId());
				} //end if
			} else {
				log.debug("getOrCreateCorporateUser(): Corporate user already exists: " + corporateUser.getId());
			}
		}
		return corporateUser;
	}	
	
	public boolean isIdEmpty(Integer id) {
		if(id == null || id.intValue() == 0)
			return true;
		return false;
	}
	
	public Activity createActivityResponse(Activity activity, List<ActivityResponse> activityResponses, UserCorporate ownerUserCorporate) {
		if(shouldCreateActivityResponseForThisApplication(activity, activityResponses, ownerUserCorporate)) {
			if(activityResponses.isEmpty())
				activity.setNote(QtreeOwnerStatus.Single.name());
			else
				activity.setNote(QtreeOwnerStatus.Multi.name());

			ActivityResponse activityResponse = new ActivityResponse();
			activityResponse.setIsPresumed(true);
			activityResponse.setOwnerUserCorporate(ownerUserCorporate);
			activityResponse.setActivity(activity);
			activityResponseRepository.save(activityResponse);
			activity.addActivityResponse(activityResponse);
			if(activity.getAdminOverride()) {
				activity.setAdminOverride(false);
			}
			activity = activityRepository.save(activity);
			return activity;
		}
		return activity;
	}
	
	public boolean shouldCreateActivityResponseForThisApplication(Activity activity, List<ActivityResponse> activityResponses, UserCorporate ownerUserCorporate) {
		boolean createActivityResponse = false;
		//Activity Response is empty so create one for this user
		if(activityResponses.isEmpty()) {
			log.debug("identifyOwner(): No activity reponse. So have to create..");
			createActivityResponse = true;
		}
		else {
			//is this owner already added for this qtree
			boolean ownerAlreadyAdded = false;
			for(ActivityResponse activityResponse: activityResponses) {
				if(activityResponse.getOwnerUserCorporate() == ownerUserCorporate) {
					ownerAlreadyAdded = true;
					break;
				}
			}
			createActivityResponse = ownerAlreadyAdded ? false : true;
			log.debug("identifyOwner(): Owner added: {}. So create activity response: {}", ownerAlreadyAdded, createActivityResponse);
		} 
		return createActivityResponse;
	}
	
	public Host updateHostAsPerActivity(Host host, Activity activity) {
		List<ActivityResponse> activityResponses = activity.getActivityResponses();
		if(!activityResponses.isEmpty()) {
			if(activity.getActivityResponses().size() == 1) {
				host.setNote(QtreeOwnerStatus.Single.name());
				host.setHostOwnerUserCorporate(activity.getActivityResponses().get(0).getOwnerUserCorporate());
			} else {
				host.setNote(QtreeOwnerStatus.Multi.name());
			}
			//TBD Implement LOB feature
			//host.setLobPresumed(lobId);
			host = hostRepository.save(host);
		}
		
		return host;
	}
}
