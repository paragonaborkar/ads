package com.netapp.ads.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.support.RepositoryEntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.models.Preference;
import com.netapp.ads.models.PreferenceDetail;
import com.netapp.ads.repos.PreferenceDetailRepository;
import com.netapp.ads.repos.PreferenceRepository;


// Be sure to include @RestController with the other annotations. 
// The example does not include it: https://docs.spring.io/spring-data/rest/docs/current/reference/html/#customizing-sdr.overriding-sdr-response-handlers
// Not including it will result in a hibernate session issue.
@RestController
@RepositoryRestController
@BasePathAwareController
public class PreferenceController { // implements ResourceProcessor<RepositoryLinksResource> {

	private static final Logger log = LoggerFactory.getLogger(PreferenceController.class);

	private static final String SYSTEM_PREF_TYPE = "SYSTEM";
	private static final String USER_PREF_TYPE 	 = "USER";

	private final PreferenceRepository preferenceRepo;

	@Autowired
	RepositoryEntityLinks entityLinks;
	
	@Autowired
	public PreferenceController(PreferenceRepository repo) { 
		preferenceRepo = repo;
	}

	@RequestMapping(value = "/getPreferencesForUser", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<?> getPreferencesForUser(
			@RequestParam("nativeUserId") Optional<String> nativeUserId,
			@RequestParam("corpUserId")   Optional<String> corpUserId,
			@RequestParam("pageName")     String pageName,
			@RequestParam("preferenceType")   String preferenceType) throws Exception {

		Preference pref = null;
		List<PreferenceDetail> userPrefDetails = null; 

		
		// Get the User's existing Preference based on the information provided.
		// Since native and corp user is optional, make sure we are always getting the right type of user.
		if (nativeUserId.isPresent() && corpUserId.isPresent()) {
			System.out.println("1:" + preferenceType + "," +  pageName + "," +  Integer.parseInt(nativeUserId.get())  + "," + Integer.parseInt(corpUserId.get()));
			pref= preferenceRepo.findByPreferenceTypeAndPageNameAndNativeUserIdAndCorpUserId(preferenceType, pageName, Integer.parseInt(nativeUserId.get()), Integer.parseInt(corpUserId.get()));
		} else if (nativeUserId.isPresent()) {
			System.out.println("2:" + preferenceType + "," +  pageName + "," +  Integer.parseInt(nativeUserId.get())  + ",");
			pref = preferenceRepo.findByPreferenceTypeAndPageNameAndNativeUserIdAndCorpUserId(preferenceType, pageName, Integer.parseInt(nativeUserId.get()), 0);
		} else if (corpUserId.isPresent()) {
			System.out.println("3:" + preferenceType + "," +  pageName + ","  + Integer.parseInt(corpUserId.get()));
			pref = preferenceRepo.findByPreferenceTypeAndPageNameAndNativeUserIdAndCorpUserId(preferenceType, pageName, 0, Integer.parseInt(corpUserId.get()));
		} else {
			//FIXME: Throw a proper REST error and error code.
			throw new Exception("Missing Paramaters");
		}

		// If we have a Preference, then return the Preference Details.
		if (pref != null) {
			
			List<Resource<PreferenceDetail>> al = new ArrayList<Resource<PreferenceDetail>>();
			Resources<PreferenceDetail> resources;
			for (PreferenceDetail prefDetail : pref.getPreferenceDetails()) {
				// We need links for each of the PreferenceDetail's show we can update the order and visibility, etc.
				// https://docs.spring.io/spring-hateoas/docs/current/reference/html/#fundamentals.obtaining-links.builder
				// https://stackoverflow.com/questions/32114137/add-link-to-spring-data-rest-repository-resource
				Link link = entityLinks.linkToSingleResource(PreferenceDetailRepository.class, prefDetail.getId());
				Resource<PreferenceDetail> res = new Resource<PreferenceDetail>(prefDetail, link);
				al.add(res);
			}

			Resources<PreferenceDetail> resources2 = new Resources(al);
			
			return new ResponseEntity(resources2, HttpStatus.OK);

		}

		// FIXME: Break this into a seperate method....
		
		// If the Preference doesn't exist, determine if we should copy from the system preference to provide a starting point.
		// We only do this when a system preference wasn't requested.
		if (pref == null && preferenceType != SYSTEM_PREF_TYPE && false) {
			// 1. Get the system preference.
			pref = preferenceRepo.findByPreferenceTypeAndPageName(SYSTEM_PREF_TYPE, pageName);

			// 2. Copy Preference to the current user.
			Preference newPref = new Preference();
			newPref.setCorpUserId(Integer.parseInt(corpUserId.get()));
			newPref.setNativeUserId(Integer.parseInt(nativeUserId.get()));
			newPref.setPageName(pageName);
			newPref.setPreferenceType(USER_PREF_TYPE);

			// 3. Copy Preference Details to the current user.
			userPrefDetails = pref.getPreferenceDetails();
			for (PreferenceDetail prefDetail : userPrefDetails) {
				PreferenceDetail newPrefDetail = new PreferenceDetail();
				newPrefDetail.setPreference(newPref);
				newPrefDetail.setFieldName(prefDetail.getFieldName());
				newPrefDetail.setFieldOrder(prefDetail.getFieldOrder());
				newPrefDetail.setFieldVisible(prefDetail.getFieldVisible());
			}

			// If we have a Preference, then return the Preference Details.
			if (newPref != null) {
				new ResponseEntity<List<PreferenceDetail>>(newPref.getPreferenceDetails(), HttpStatus.OK);
			}

		}

		// If we got to here, we don't have it.
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);


	}

//	@Override
//	public RepositoryLinksResource process(RepositoryLinksResource resource) {
////		   resource.add(ControllerLinkBuilder.linkTo(CustomRootController.class).withRel("others"));
//			super(resource);
//	        return resource;
//	}

}
