package com.netapp.ads.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.ActivityResponse;
import com.netapp.ads.models.Application;
import com.netapp.ads.models.Host;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.QtreeDisposition;
import com.netapp.ads.models.Share;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.repos.ActivityResponseRepository;
import com.netapp.ads.repos.HostRepository;
import com.netapp.ads.repos.QtreeDispositionRepository;

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
			List<Application> applications = applicationService.createApplicationAndUsers(host);
			for(Application application: applications) {
				List<ActivityResponse> activityResponses = activity.getActivityResponses();
				createActivityResponse(activity, activityResponses, application.getOwnerUserCorporateId());
			} //end of for loop for applications
			
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
				createActivityResponse(activity, activityResponses, host.getHostOwnerUserCorporateId());
			} // else
		} //main else for host
	}
	
	public boolean isIdEmpty(Integer id) {
		if(id == null || id.intValue() == 0)
			return true;
		return false;
	}
	
	public Activity createActivityResponse(Activity activity, List<ActivityResponse> activityResponses, Integer ownerUserCorporateId) {
		if(shouldCreateActivityResponseForThisApplication(activity, activityResponses, ownerUserCorporateId)) {
			if(activityResponses.isEmpty())
				activity.setNote(QtreeOwnerStatus.Single.name());
			else
				activity.setNote(QtreeOwnerStatus.Multi.name());

			ActivityResponse activityResponse = new ActivityResponse();
			activityResponse.setIsPresumed(true);
			activityResponse.setOwnerUserCorporateId(ownerUserCorporateId);
			activityResponse.setActivity(activity);
			activityResponseRepository.save(activityResponse);
			activity.addActivityResponse(activityResponse);
			activity = activityRepository.save(activity);
			return activity;
		}
		return activity;
	}
	
	public boolean shouldCreateActivityResponseForThisApplication(Activity activity, List<ActivityResponse> activityResponses, Integer ownerUserCorporateId) {
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
				if(activityResponse.getOwnerUserCorporateId().intValue() == ownerUserCorporateId.intValue()) {
					ownerAlreadyAdded = true;
					break;
				}
			}
			createActivityResponse = ownerAlreadyAdded ? false : true;
			log.debug("identifyOwner(): Owner added: {}. So create activity response: {}", ownerAlreadyAdded, createActivityResponse);
		} //end if(activityResponses.isEmpty())
		
		return createActivityResponse;
	}
	
	public Host updateHostAsPerActivity(Host host, Activity activity) {
		List<ActivityResponse> activityResponses = activity.getActivityResponses();
		if(!activityResponses.isEmpty()) {
			if(activity.getActivityResponses().size() == 1) {
				host.setNote(QtreeOwnerStatus.Single.name());
				host.setHostOwnerUserCorporateId(activity.getActivityResponses().get(0).getOwnerUserCorporateId());
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
