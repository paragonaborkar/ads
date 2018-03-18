package com.netapp.ads.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netapp.ads.models.Host;
import com.netapp.ads.models.UserCorporate;
import com.netapp.ads.models.verum.application.Application;
import com.netapp.ads.models.verum.application.OSI;
import com.netapp.ads.models.verum.application.VerumObjectList;
import com.netapp.ads.models.verum.esource.EmployeeList;
import com.netapp.ads.models.verum.esource.EmployeeProfile;
import com.netapp.ads.models.verum.person.Person;
import com.netapp.ads.repos.ApplicationRepository;
import com.netapp.ads.repos.LineOfBusinessRepository;
import com.netapp.ads.repos.UserCorporateRepository;

@Service
public class ApplicationService {
	
	@Value("${verum.rest.api.osi.contact_type.uri}")
	public String verumOSIContactTypeUri;
	
	@Value("${verum.rest.api.person.uri}")
	public String verumOSIPersonUri;
	
	@Value("${verum.rest.esource.uri}")
	public String eSourceUri;

	@Autowired
	public ApplicationRepository applicationRepository;
	
	@Autowired
	public UserCorporateRepository userCorporateRepository;
	
	@Autowired
	public LineOfBusinessRepository lineOfBusinessRepository;
	
	
	private Logger log = LoggerFactory.getLogger(ApplicationService.class);
	private final RestTemplate restTemplate;
	
	public ApplicationService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.basicAuthorization("bill", "abc123").build();
	}
	
	public OSI getVerumApp(String ipAddress) {
		log.debug("getVerumApp(): [ENTERED] : ipAddress: " + ipAddress);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("primaryIP", ipAddress);
		
		ResponseEntity<OSI> responseEntity = restTemplate.exchange(verumOSIContactTypeUri, HttpMethod.GET, new HttpEntity<HttpHeaders>(getDefaultHttpHeaders()) , OSI.class, params);
		OSI osi = responseEntity.getBody();
		
		log.debug("getVerumApp(): [EXIT]");
		
		return osi;
	}
	
	public Person getVerumPerson(String sid) {
		log.debug("getVerumPerson(): [ENTERED] : sid: " + sid);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("standardID", sid);
		
		ResponseEntity<Person> responseEntity = restTemplate.exchange(verumOSIPersonUri, HttpMethod.GET, new HttpEntity<HttpHeaders>(getDefaultHttpHeaders()) , Person.class, params);
		Person person = responseEntity.getBody();
        log.debug("getVerumPerson(): Person: " + person.toString());
        
        return person;
	}	
	
	public EmployeeProfile getEmployeeProfile(String sid) {
		log.debug("getEsourceContact(): [ENTERED] : sid: " + sid + ", eSourceUri: " + eSourceUri);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("standardID", sid);
		
		EmployeeProfile employeeProfile = restTemplate.getForObject(eSourceUri, EmployeeProfile.class, params);
		log.debug("getEsourceContact(): employeeProfile: " + employeeProfile.toString());
        return employeeProfile;
	}
	
	public List<com.netapp.ads.models.Application> createApplicationAndUsers(Host host) {
		String ipAddress = host.getIpAddr();
		log.debug("createApplicationAndUsers(): [ENTERED]: ipAddress: " + ipAddress);
		OSI osi = getVerumApp(ipAddress);
		List<com.netapp.ads.models.Application> applications = new ArrayList<>();
		if(osi != null) {
			List<VerumObjectList> verumObjectLists = osi.getVerumObjectList();
			for (VerumObjectList verumObjectList : verumObjectLists) {
				List<Application> verumApplications = verumObjectList.getApplication();
				for(Application verumApplication : verumApplications) {
					com.netapp.ads.models.Application application = applicationRepository.findByApplicationCode(verumApplication.getAppID());
					if(application == null) {
						log.debug("createApplicationAndUsers(): Application DOES NOT exist. Creating.." );
						application = new com.netapp.ads.models.Application();
						//THERE ARE MULTIPLE CONTACTS. LOOKS LIKE OLD CODE IS PICKING ONLY THE LAST ONE. SO DID WE
						//CAN AN APPLICATION NOT HAVE MORE THAN 1 CONTACT?
						UserCorporate corporateUser = getOrCreateCorporateUser(verumApplication.getContact().get(0).getSid());
						if(corporateUser != null) {
							application.setOwnerUserCorporateId(corporateUser.getId()); //WHAT IF CORPORATE USER DOES NOT EXIST IN SYSTEM? SHOULD WE CREATE? VERUM IS SENDING MULTIPLE CONTACTS
						}
						
						if(!application.getHosts().contains(host)) {
							application.addHost(host);
						}
						application.setApplicationName(verumApplication.getApplicationName());
						application.setApplicationCode(verumApplication.getAppID());
						//application.setArchtype(verumApplication.get); WHERE TO GET THIS FROM?
						//application.setHosts(hosts); DO WE NEED TO SET THIS?
						application.setInformationOwner(verumApplication.getTechGroupOwner()); //IS THIS CORRECT?
						//application.setLineOfBusinesses(new ListverumApplication.getOwningLOB()); //DO WE NEED TO SET THIS?
						application = applicationRepository.save(application);
						log.debug("createApplicationAndUsers(): Application Created/Updated: " + application.getId());
					} else {
						log.debug("createApplicationAndUsers(): Application already exists: " + application.getId());
					}
					applications.add(application);
				}
			}
		}
		log.debug("createApplicationAndUsers(): [EXIT]");
		return applications;
	}
	
	public UserCorporate getOrCreateCorporateUser(String sid) {
		log.debug("getOrCreateCorporateUser: sid: " + sid);
		UserCorporate corporateUser = null;
		Person person = getVerumPerson(sid);
		if(person != null && !person.getVerumObjectList().isEmpty()) {
			List<com.netapp.ads.models.verum.person.VerumObjectList> personVerumObjectLists = person.getVerumObjectList();
			com.netapp.ads.models.verum.person.VerumObjectList personVerumObjectList = personVerumObjectLists.get(0);
			UserCorporate manager = userCorporateRepository.findFirstByUserName(personVerumObjectList.getManagerSid());
			if(manager == null) {
				log.debug("getOrCreateCorporateUser(): Manager does not exist");
				EmployeeProfile managerProfile = getEmployeeProfile(personVerumObjectList.getManagerSid());
				if(managerProfile != null && !managerProfile.getEmployeeList().isEmpty()) {
					EmployeeList managerEmployee = managerProfile.getEmployeeList().get(0);
					manager = new UserCorporate();
					manager.setUserName(personVerumObjectList.getManagerSid());
					manager.setFirstName(managerEmployee.getFirstName());
					manager.setLastName(managerEmployee.getLastName());
					manager.setMiddleName(managerEmployee.getMiddle());
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
				
				EmployeeProfile employeeProfile = getEmployeeProfile(sid);
				if(employeeProfile != null && !employeeProfile.getEmployeeList().isEmpty()) {
					//We are getting a targeted user here based on SID so this list should always have 1 value
					EmployeeList employee = employeeProfile.getEmployeeList().get(0);
					corporateUser.setFirstName(employee.getFirstName());
					corporateUser.setLastName(employee.getLastName());
					corporateUser.setMiddleName(employee.getMiddle());
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
	

	public HttpHeaders getDefaultHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8, MediaType.APPLICATION_JSON)); 
		return headers;
	}
}
