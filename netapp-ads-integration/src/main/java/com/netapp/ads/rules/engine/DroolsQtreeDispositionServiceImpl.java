package com.netapp.ads.rules.engine;

import java.util.List;

import org.drools.core.base.RuleNameStartsWithAgendaFilter;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.repos.ActivityRepository;
import com.netapp.ads.repos.QtreeDispositionRepository;
import com.netapp.ads.services.DroolsHelper;

@Service
public class DroolsQtreeDispositionServiceImpl implements QtreeDispositionService {

	private static final Logger logger = LoggerFactory.getLogger(DroolsQtreeDispositionServiceImpl.class);
	
	/**
	 * Drools Kie container autowired through constructor
	 */
	private final KieContainer kieContainer;
	
	/**
	 * Drools Kie services autowired throuh constructor
	 */
	private final KieServices kieServices;
	
	
	@Autowired
	QtreeDispositionRepository qtreeDispositionRepository;
	
	@Autowired
	DroolsHelper droolsHelper;
	
	
	@Autowired
	ActivityRepository activityRepository;
	
	//For future use to improve performance when using one session for a request
	//private List<FactHandle> facts = new ArrayList<FactHandle>();
	
	
	@Autowired
	public DroolsQtreeDispositionServiceImpl(KieContainer kieContainer, KieServices kieServices) {
		this.kieContainer = kieContainer;
		this.kieServices = kieServices;
	}
	
	/* (non-Javadoc)
	 * @see com.netapp.ads.rules.engine.QtreeDispositionService#executeQtreeDispositionRules(java.util.List)
	 */
	@Override
	public void executeQtreeDispositionRules(List<Qtree> qtrees) {
		//logger.info("executeQtreeDispositionRules: [ENTER]");
			
		if( !qtrees.isEmpty()) {
			for(Qtree qtree: qtrees) {
				logger.info("executeQtreeDispositionRules: Qtree: " + qtree.getId());
				KieSession kieSession = null;
				try {
					kieSession = kieContainer.newKieSession();
					//For logging and debugging purposes
					//kieLogger = kieServices.getLoggers().newFileLogger(kieSession, "C:/ads-spring-boot-logs/audit.log");
					//kieLogger.close();
					//kieSession.addEventListener( new DebugAgendaEventListener() );
					//kieSession.addEventListener( new DebugProcessEventListener() );
					kieSession.setGlobal("logger", logger);
					kieSession.insert(droolsHelper);
					kieSession.insert(qtree);
					kieSession.insert(qtreeDispositionRepository);
					kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("Discovery -"));	
					//To fire a single rule by its name
					//kieSession.fireAllRules(new RuleNameMatchesAgendaFilter("Controller Root Rule"));					
				} finally {
					if(kieSession != null)
						kieSession.dispose();
				}
				logger.info("executeQtreeDispositionRules: Qtree DISPOSITION SIZE: " + qtree.getQtreeDisposition().size());
				populateActivity(qtree);
			}
		}
		//logger.info("executeQtreeDispositionRules: [EXIT]");
	}
	
	public boolean populateActivity(Qtree qtree) {
		//Not sure why we iterate through all the qtrees. Can we filter this based on the disposition and justification we set earlier in the rules engine
		Activity activity = new Activity();
		activity.setQtree(qtree);
		activity.setWillDecommission(false);  // This is set when QTree Owners confirm ownership
		activity.setWillMigrate(false); // This is set when QTree Owners confirm ownership
		activity.setAdminOverride(false);
		activityRepository.save(activity);
		logger.info("populateActivity: Created Activity: " + activity.getId());
		return true;
	}
}
