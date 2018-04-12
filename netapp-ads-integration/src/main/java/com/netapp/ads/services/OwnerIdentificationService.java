package com.netapp.ads.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.ActivityResponse;
import com.netapp.ads.models.Application;
import com.netapp.ads.models.Host;
import com.netapp.ads.models.LineOfBusiness;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.QtreeDisposition;
import com.netapp.ads.models.Share;
import com.netapp.ads.models.UserCorporate;
import com.netapp.ads.pojo.ApplicationOwnerPojo;
import com.netapp.ads.pojo.ApplicationPojo;
import com.netapp.ads.pojo.ApplicationsPojo;
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
	
	@Value("#{sysConfigRepository.findByPropertyName('ads.rules.discovery_rule.disposition').getPropertyValue()}")
	public String discoveryDisposition;
	
	@Value("#{sysConfigRepository.findByPropertyName('ads.talend.cmdb.url').getPropertyValue()}")
	public String talendCMDBUrl;
	
	@Autowired
	public ActivityRepository activityRepository;
	
	@Autowired
	public ActivityResponseRepository activityResponseRepository;
	
	@Autowired
	public HostRepository hostRepository;	
	
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
	
	@Autowired
	private RestTemplate restTemplate;
	
	public ApplicationsPojo getApplications(String hostIp) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		log.debug("Calling Talend to get application information GET:" + talendCMDBUrl + hostIp);
		ApplicationsPojo applications = restTemplate.getForObject(talendCMDBUrl + hostIp, ApplicationsPojo.class);
		return applications;
	}

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
		//FIXME: Remove method argument for ApplicationWrapper and add code to fetch Application Wrapper from Talend.. 
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
				processHost(host, activity, getApplications(host.getIpAddr()));
			}
		} //end of for
			
		log.debug("identifyOwner(): [EXIT]");
	}
	
	private void processHost(Host host, Activity activity, ApplicationsPojo applications) {
		if( isIdEmpty(host.getHostOwnerUserCorporateId()) ) {
			log.debug("identifyOwner(): No corporate ID on host so going through applications");
			
			//Based on the hosts IP Addresses call CMDB to fetch applications and corresponding corporate owner users
			//then for each corporate user create an activity response which will assist in owner identification
			createApplicationUsersAndActivityResponses(host, activity, applications);
			
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
				createActivityResponse(activity, host.getHostOwnerUserCorporate());
			} // else
		} //main else for host
	}
	
	
	
	/**
	 * Creates Applications corresponding Corporate Users and Activity Responses for each
	 * 
	 * @param host Associated with this application
	 * @param activity tied to this application
	 * @param receivedData  Data recieved from CMDB
	 * @return
	 */
	public List<Application> createApplicationUsersAndActivityResponses(Host host, Activity activity, ApplicationsPojo applicationsPojo) {
		String ipAddress = host.getIpAddr();
		log.debug("createApplicationAndUsers(): [ENTERED]: ipAddress: " + ipAddress);
		List<Application> applications = new ArrayList<>();
		if(applicationsPojo != null && !applicationsPojo.getApplications().isEmpty()) {
				for(ApplicationPojo applicationPojo: applicationsPojo.getApplications()) {
					Application application = applicationRepository.findByApplicationCode(applicationPojo.getCode());
					if(application == null) {
						UserCorporate corpUser = getOrCreateCorporateUser(applicationPojo.getOwner());;
						createActivityResponse(activity, corpUser);
						
						LineOfBusiness lob = getOrCreateLob(applicationPojo.getOwningLOB());
						log.debug("createApplicationAndUsers(): Application DOES NOT exist. Creating.." );
						application = new Application();
						if(!application.getHosts().contains(host)) {
							application.addHost(host);
						}
						application.setApplicationName(applicationPojo.getName());
						application.setApplicationCode(applicationPojo.getCode());
						application.setOwnerUserCorporateId(corpUser.getId());
						//FIXME: application.setArchtype(verumApplication.get); WHERE TO GET THIS FROM?
						application.setInformationOwner(applicationPojo.getInformationOwner()); //IS THIS CORRECT?
						if(lob != null) {
							application.addLineOfBusinesses(lob);
						}
						application = applicationRepository.save(application);
						
						if(lob != null && !activity.getLineOfBusinessesXRefActivities().contains(lob)) {
							activity.addLineOfBusinesses(lob);
							activityRepository.save(activity);
						}
						log.debug("createApplicationAndUsers(): Application Created/Updated: " + application.getId());
					} else {
						if(activity.getAdminOverride()) {
							createActivityResponse(activity, getOrCreateCorporateUser(applicationPojo.getOwner()));
						}
						log.debug("createApplicationAndUsers(): Application already exists: " + application.getId());
					}
					applications.add(application);
				}
		} else {
			log.info("createApplicationAndUsers(): No application recieved");
		}
		log.debug("createApplicationAndUsers(): [EXIT]");
		return applications;
	}
	
	/**
	 * Get LOB if exists or create one
	 * 
	 * @param lobName Name of the LOB
	 * @return
	 */
	public LineOfBusiness getOrCreateLob(String lobName) {
		if(lobName == null)
			return null;
		LineOfBusiness lob = lineOfBusinessRepository.findByLobName(lobName);
		if(lob == null) {
			lob = new LineOfBusiness();
			lob.setLobName(lobName);//this is the only attribute we get from CMDB
			lineOfBusinessRepository.save(lob);
		}
		return lob;
	}
	
	/**
	 * Get Corporate User if exists else create one
	 * 
	 * @param appOwnerPojo User Details to fetch or create Corporate User
	 * @return
	 */
	public UserCorporate getOrCreateCorporateUser(ApplicationOwnerPojo appOwnerPojo) {
		UserCorporate corporateUser = null;
		if(appOwnerPojo != null) {
			UserCorporate managerUser = null;
			if(appOwnerPojo.getManager() != null) {
				managerUser = userCorporateRepository.findFirstByEmail(appOwnerPojo.getManager().getEmail());
				log.debug("getOrCreateCorporateUser: manager email: {}: managerUser", appOwnerPojo.getManager().getEmail(), managerUser);
				if(managerUser == null) {
					log.debug("getOrCreateCorporateUser: Manager user does not exist. Creating...");
					managerUser = getOrCreateCorporateUser(appOwnerPojo.getManager());
				} else {
					log.debug("getOrCreateCorporateUser: Manager exists. No need to create");
				}				
			}
			corporateUser = userCorporateRepository.findFirstByEmail(appOwnerPojo.getEmail());
			log.debug("getOrCreateCorporateUser: corp user email: {}: corporateUser", appOwnerPojo.getEmail(), corporateUser);
			if(corporateUser == null) {
				log.debug("getOrCreateCorporateUser: Corp user does not exist. Creating...");
				corporateUser = new UserCorporate();
				corporateUser.setBestPhone(appOwnerPojo.getPhoneNum());
				corporateUser.setCostCenter(appOwnerPojo.getCostCenter());
				corporateUser.setEmail(appOwnerPojo.getEmail());
				corporateUser.setFirstName(appOwnerPojo.getFirstName());
				corporateUser.setLastName(appOwnerPojo.getLastName());
				corporateUser.setUserName(appOwnerPojo.getUserName());
				corporateUser.setMiddleName(appOwnerPojo.getMiddleName());
				corporateUser.setUserRole(userRoleRepository.findOneByUserRole("ROLE_USER"));
				corporateUser.setUserCorporateManager(managerUser);
				userCorporateRepository.save(corporateUser);
			} else {
				log.debug("getOrCreateCorporateUser: Corp user exists. No need to create");
			}
		}
		return corporateUser;
	}
	
	/**
	 * Check if Integer ID is empty
	 * 
	 * @param id
	 * @return
	 */
	public boolean isIdEmpty(Integer id) {
		if(id == null || id.intValue() == 0)
			return true;
		return false;
	}
	
	/**
	 * Create Activity response for an activity and corporate user
	 * 
	 * @param activity
	 * @param ownerUserCorporate
	 * @return
	 */
	public Activity createActivityResponse(Activity activity, UserCorporate ownerUserCorporate) {
		if(shouldCreateActivityResponseForThisApplication(activity, ownerUserCorporate)) {
			if(activity.getActivityResponses().isEmpty())
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
	
	/**
	 * Check if activity response should be created for this application and corporate user
	 * 
	 * @param activity
	 * @param ownerUserCorporate
	 * @return
	 */
	public boolean shouldCreateActivityResponseForThisApplication(Activity activity, UserCorporate ownerUserCorporate) {
		boolean createActivityResponse = false;
		//Activity Response is empty so create one for this user
		if(activity.getActivityResponses().isEmpty()) {
			log.debug("identifyOwner(): No activity reponse. So have to create..");
			createActivityResponse = true;
		}
		else {
			//is this owner already added for this qtree
			boolean ownerAlreadyAdded = false;
			for(ActivityResponse activityResponse: activity.getActivityResponses()) {
				if(activityResponse.getOwnerUserCorporate() == ownerUserCorporate) {
					ownerAlreadyAdded = true;
					break;
				}
			}
			createActivityResponse = ownerAlreadyAdded ? false : true;
			log.debug("identifyOwner(): AR already exists for this Owner? {}. So create activity response: {}", ownerAlreadyAdded, createActivityResponse);
		} 
		return createActivityResponse;
	}
	
	/**
	 * Update host information based on other processing
	 * 
	 * @param host
	 * @param activity
	 * @return
	 */
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
