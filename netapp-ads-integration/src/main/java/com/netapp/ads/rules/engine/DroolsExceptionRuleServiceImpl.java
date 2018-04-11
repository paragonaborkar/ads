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

import com.netapp.ads.models.Qtree;
import com.netapp.ads.repos.QtreeDispositionRepository;
import com.netapp.ads.services.DroolsHelper;

@Service
public class DroolsExceptionRuleServiceImpl implements ExceptionRuleService {
	private static final Logger logger = LoggerFactory.getLogger(DroolsExceptionRuleServiceImpl.class);
	
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
	
	//For future use to improve performance when using one session for a request
	//private List<FactHandle> facts = new ArrayList<FactHandle>();
	
	
	@Autowired
	public DroolsExceptionRuleServiceImpl(KieContainer kieContainer, KieServices kieServices) {
		this.kieContainer = kieContainer;
		this.kieServices = kieServices;
	}
	

	/* (non-Javadoc)
	 * @see com.netapp.ads.rules.engine.ExceptionRuleService#executeQtreeExceptionRules(java.util.List)
	 */
	@Override
	public void executeQtreeExceptionRules(List<Qtree> qtrees) {
		logger.info("executeQtreeDispositionRules: [ENTER]");
			
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
					kieSession.insert(qtree.getQtreeDisposition());
					kieSession.insert(qtreeDispositionRepository);
					//To fire a single rule by its name
					kieSession.fireAllRules(new RuleNameStartsWithAgendaFilter("Exception -"));			
				} finally {
					if(kieSession != null)
						kieSession.dispose();
				}
			}
		}
		logger.info("executeQtreeDispositionRules: [EXIT]");
	}
}
