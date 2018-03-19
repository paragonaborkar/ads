package com.netapp.ads.services;

import java.util.Arrays;
import java.util.HashMap;
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

import com.netapp.ads.models.verum.application.OSI;
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
	
	public HttpHeaders getDefaultHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.TEXT_PLAIN);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON_UTF8, MediaType.APPLICATION_JSON)); 
		return headers;
	}
}
