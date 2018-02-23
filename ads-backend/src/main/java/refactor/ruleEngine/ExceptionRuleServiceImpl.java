/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/
package refactor.ruleEngine;

import java.util.ArrayList;
import java.util.List;


import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.models.Controller;
import com.netapp.ads.models.NasVolume;


import refactor.rules.AccessControlRule;
import refactor.rules.AgedAccessRule;
import refactor.rules.ControllerRootRule;
import refactor.rules.DiscoveryRule;
//import refactor.rules.MissingRootVolRule;
import refactor.services.ShareService;
import refactor.services.VolumeService;

@Service
public class ExceptionRuleServiceImpl implements ExceptionRuleService {
	private static final Logger logger = LoggerFactory.getLogger(ExceptionRuleServiceImpl.class);

	private List<NasVolume> volList;

//	@Autowired
//	MissingRootVolRule missingRoot;

	

	@Autowired
	VolumeService volService;

//	@Autowired
//	ControllerService contService;

	@Autowired
	ShareService shareService;

	private List<Integer> ruleContIdList = new ArrayList<Integer>();
	List<NasVolume> ruleVolumeList = new ArrayList<NasVolume>();//using volumeentity to match with other rules in the rule set otherwise need to create separate Ksession 

	private Controller contEnt;
	private String contName;
//	public void exceptionRule(List<CtrlReleaseEntity> crList){
	public void exceptionRule(List<Controller> controllers){
		logger.debug("Starting Exception Rule Engine");

//		RulesEngine exceptEngine = RulesEngineBuilder
//				.aNewRulesEngine()
//				.named("Exception Rules Engine")
//				.withSkipOnFirstAppliedRule(false)
//				.withSilentMode(true)
//				.build();
		RulesEngine exceptEngine = new DefaultRulesEngine();
		// adding rules to engine
//		exceptEngine.registerRule(missingRoot);
		
		Rules rules = new Rules();
		// SZ &&&&&&&& UNCOMMENT THIS
//		rules.register(missingRoot);

		
		try {
			for (Controller controller : controllers){
				// Passing single Controller Release Entity to the rule
//				missingRoot.setCtrlRelease(controller);
//				exceptEngine.fireRules();
				
				Facts facts = new Facts();
				facts.put("controller", controller);
				exceptEngine.fire(rules, facts);
			}
		} catch (Exception e) {
			logger.error("Unable to run one or more rules: {}",e.getMessage());
		}

		logger.debug("Ending Exception Rule Engine");
	}

	@Autowired
	ControllerRootRule controllerRootRule;

	@Autowired
	AgedAccessRule agedAccessRule;

	@Autowired
	AccessControlRule accessControlRule;

	@Autowired
	DiscoveryRule discoveryRule;

	@Override

	// We don't have CtrlRelease in ADS
	//	public void fireDroolsExceptionRule(List<CtrlReleaseEntity> crList) {
	public void fireDroolsExceptionRule(List<Controller> controllers) {

		logger.debug("In Missing Root drools rule engine ");

		try {
			
			for (Integer contId: ruleContIdList){
				logger.debug("Volume back from rule: "+contId.intValue());
				try {
//					contEnt = contService.getById(contId);
					contName = contEnt.getControllerName();
					logger.info("Missing ROOT Volume Rule: {}", contName);
				} catch (Exception e) {
					logger.error(e.getMessage(),e);
				}
			}

			Rules rules = new Rules();
			//Need to update below rule methods to accept Facts instead of using setter methods
			rules.register(shareService);
			rules.register(ruleVolumeList);
			rules.register(ruleContIdList);


			RulesEngine rulesEngine = new DefaultRulesEngine();
			for (Controller controller : controllers) {
				for (NasVolume volume : controller.getNasVolumes()) {
					Facts facts = new Facts();
					facts.put("nasVolume", volume);
					rulesEngine.fire(rules, facts);
				}
			}

			System.out.println("IN Mising Root Rule ContId size:"+ruleContIdList.size());
//			System.out.println("IN Mising Root Rule Volume size:"+ruleVolumeList.size());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Unable to execute one or more rules",e); 
		}
		logger.debug("End drools rule engine");
	}
}
