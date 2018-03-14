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
import com.netapp.ads.models.Share;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.repos.ActivityResponseRepository;
import com.netapp.ads.repos.HostRepository;

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
	
	public void identifyOwner() {
		log.debug("identifyOwner(): [ENTER] ");
		
		List<Activity> activities = activityRepository.findByDisposition(discoveryDisposition);
		for(Activity activity: activities) {
			log.debug("identifyOwner(): activity: " + activity.getId());
			Qtree qtree = activity.getQtree();
			if(qtree != null) {
				log.debug("identifyOwner(): qtree: " + qtree.getId());
				List<Share> shares = qtree.getShares();
				log.debug("identifyOwner(): shares: " + shares.size());
				for(Share share: shares) {
					Host host = share.getHost();
					log.debug("identifyOwner(): share: " + share.getId());
					log.debug("identifyOwner(): host: " + host.getId());
					log.debug("identifyOwner(): host owner: " + host.getHostOwnerUserCorporateId());
					if( host.getHostOwnerUserCorporateId() == null || host.getHostOwnerUserCorporateId().intValue() == 0){
						log.debug("identifyOwner(): in first if");
						List<Application> applications = applicationService.createApplicationAndUsers(host.getIpAddr());
						for(Application application: applications) {
							
							Integer applicationOwnerId = application.getOwnerUserCorporateId(); 
							
							List<ActivityResponse> activityResponses = activity.getActivityResponses();
							
							if(activityResponses.isEmpty()) {
								log.debug("identifyOwner(): No activity reponse. Creating..");
								ActivityResponse activityResponse = new ActivityResponse();
								activityResponse.setIsPresumed(true);
								activityResponse.setOwnerUserCorporateId(applicationOwnerId);
								activityResponse.setActivity(activity);
								activityResponseRepository.save(activityResponse);
								activity.addActivityRespons(activityResponse);
								activity.setNote(QtreeOwnerStatus.Single.name());
								//activity.setAppNameList(application.getApplicationName());
								activity = activityRepository.save(activity);
								//TBD Implement LOB feature
								//activity.setLineOfBusinessesXRefPresumedActivities(lineOfBusinessesXRefPresumedActivities);
							} else {
								boolean ownerAlreadyAdded = false;
								for(ActivityResponse activityResponse: activityResponses) {
									if(activityResponse.getOwnerUserCorporateId().intValue() == applicationOwnerId.intValue()) {
										ownerAlreadyAdded = true;
										break;
									}
								}
								log.debug("identifyOwner(): ownerAlreadyAdded: {}", ownerAlreadyAdded);
								if(!ownerAlreadyAdded) {
									log.debug("identifyOwner(): Created another Activity Response");
									ActivityResponse activityResponse = new ActivityResponse();
									activityResponse.setIsPresumed(true);
									activityResponse.setOwnerUserCorporateId(applicationOwnerId);
									activity.addActivityRespons(activityResponse);
									activity.setNote(QtreeOwnerStatus.Multi.name());
									//activity.setAppNameList(application.getApplicationName());
									activity = activityRepository.save(activity);
									//TBD Implement LOB feature
									//activity.setLineOfBusinessesXRefPresumedActivities(lineOfBusinessesXRefPresumedActivities);
								}
							}
							//UPDATE HOST
							
							if( (host.getHostOwnerUserCorporateId() == null || host.getHostOwnerUserCorporateId().intValue() == 0)
									||(host.getHostOwnerUserCorporateId().intValue() == application.getOwnerUserCorporateId() && activity.getNote().equals(QtreeOwnerStatus.Single.name())) ) {
								log.debug("identifyOwner(): In if for host");
								host.setHostOwnerUserCorporateId(application.getOwnerUserCorporateId());
								//TBD Implement LOB feature
								//host.setLobPresumed(lobId);
								host.setNote(QtreeOwnerStatus.Single.name());
							} else {
								//CANT DO ANUTHING ELSE SINCE THERE IS NO LOB AND REFERS TO JUST ONE OWNER
								log.debug("identifyOwner(): In else for host");
								host.setNote(QtreeOwnerStatus.Multi.name());						
							}
							hostRepository.save(host);
							//UPDATE HOST
						}
					} else {
						log.debug("identifyOwner(): Duplicate Host {} owner: associated with IP:{}", host.getHostOwnerUserCorporateId(), host.getIpAddr());
			
						//if activity does not have owner or activities owner ID is samee as hosts owner ID and activity is SINGLE then
						List<ActivityResponse> activityResponses = activity.getActivityResponses();
						if(
								activityResponses.isEmpty() || 
								(activityResponses.size() == 1 && activityResponses.get(0).getOwnerUserCorporateId().intValue() == host.getHostOwnerUserCorporateId() && activity.getNote().equals(QtreeOwnerStatus.Single.name()))
						) {
							//ADD LOGIC FOR LOB
							log.debug("identifyOwner(): in if");
							if(host.getNote().equals(QtreeOwnerStatus.Multi.name())) {
								activity.setNote(QtreeOwnerStatus.Multi.name());
							} else {
								activity.setNote(QtreeOwnerStatus.Single.name());
							}
						} else {
							log.debug("identifyOwner(): in else");
							boolean ownerAlreadyAdded = false;
							for(ActivityResponse activityResponse: activityResponses) {
								if(activityResponse.getOwnerUserCorporateId().intValue() == host.getHostOwnerUserCorporateId().intValue()) {
									ownerAlreadyAdded = true;
									break;
								}
							}
							log.debug("identifyOwner(): ownerAlreadyAdded: {}", ownerAlreadyAdded);
							if(!ownerAlreadyAdded) {
								ActivityResponse activityResponse = new ActivityResponse();
								activityResponse.setIsPresumed(true);
								activityResponse.setOwnerUserCorporateId(host.getHostOwnerUserCorporateId());
								activity.addActivityRespons(activityResponse);
								activity.setNote(QtreeOwnerStatus.Multi.name());
								//activity.setAppNameList(application.getApplicationName());
								activity = activityRepository.save(activity);
								//TBD Implement LOB Presumed feature
								//activity.setLineOfBusinessesXRefPresumedActivities(lineOfBusinessesXRefPresumedActivities);
							}
	
						}
					}
				}
			}
		}
		log.debug("identifyOwner(): [EXIT]");
	}
}
