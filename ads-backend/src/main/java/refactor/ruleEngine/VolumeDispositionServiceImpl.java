package refactor.ruleEngine;
/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/


import java.util.ArrayList;
import java.util.List;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.api.Facts;
//import org.easyrules.api.RulesEngine;
//import org.easyrules.core.RulesEngineBuilder;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.jeasy.rules.core.RulesEngineBuilder;
//import org.kie.api.KieServices;
//import org.kie.api.runtime.KieContainer;
//import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import refactor.services.ShareService;
import refactor.services.VolumeService;
import refactor.services.ImpactService;
import refactor.services.HostService;
import com.netapp.ads.models.NasVolume;

import refactor.rules.AccessControlRule;
import refactor.rules.AgedAccessRule;
import refactor.rules.ControllerRootRule;
import refactor.rules.DiscoveryRule;

/**
 * This is the engine hold all the rules to run
 * @author sofiaz
 *
 */
@Service
public class VolumeDispositionServiceImpl implements VolumeDispositionService{

	private static final Logger logger = LoggerFactory.getLogger(VolumeDispositionServiceImpl.class);
	
	@Autowired
	ControllerRootRule controllerRootRule;
	
	@Autowired
	AgedAccessRule agedAccessRule;
	
	@Autowired
	AccessControlRule accessControlRule;
	
	@Autowired
	DiscoveryRule discoveryRule;
	
	@Autowired
	VolumeService volService;
	@Autowired
	ShareService shareService;
	@Autowired
	HostService hostService;
	@Autowired
	ImpactService impactService;
	
	private List<NasVolume> ruleVolumeList = new ArrayList<NasVolume>();
	private List<Integer> ruleContIdList = new ArrayList<Integer>();//This is for missing root rule
	public void volDisposition(List<NasVolume> volList) {

		logger.info("Start rule engine in volDisposition");
/*
		RulesEngine volRulesEngine = RulesEngineBuilder
				.aNewRulesEngine()
				.named("Volume Rules Engine")
				.withSkipOnFirstAppliedRule(false)
				.withSilentMode(true)
				.build();

		// Adding rules to the engine
		volRulesEngine.registerRule(controllerRootRule);
		volRulesEngine.registerRule(agedAccessRule);
		volRulesEngine.registerRule(accessControlRule);
		volRulesEngine.registerRule(discoveryRule);

		try {

			for (NasVolume volume : volList) {
				// Passing the single Volume Entity to the rule
				controllerRootRule.setVolume(volume);
				agedAccessRule.setVolume(volume);
				accessControlRule.setVolume(volume);
				discoveryRule.setVolume(volume);

				// Executing the Volume Rule Engine
				volRulesEngine.fireRules();
				
			}
		} catch(Exception e) {
			logger.error("Unable to execute one or more rules",e); 
		}*/
		
		Rules rules = new Rules();
		//Need to update below rule methods to accept Facts instead of using setter methods
		rules.register(controllerRootRule);
		rules.register(agedAccessRule);
		rules.register(accessControlRule);
		rules.register(discoveryRule);
		
		RulesEngine rulesEngine = new DefaultRulesEngine();
		for (NasVolume volume : volList) {
			Facts facts = new Facts();
			facts.put("nasVolume", volume);
			rulesEngine.fire(rules, facts);
        }
		
		logger.info("End rule engine in volDisposition");
	}
	
	public void fireDroolsRules(List<NasVolume> volList) {

		logger.info("Starting drools rule engine in volDisposition");

		//Change to stateless session change the session type in kmodule.xml then:
		//StatelessKieSession kSession = kieContainer.newStatelessKieSession();
		//...setGlobals here...
		//courseMatchSession.execute(volList);
		
        try {
        	
        	//**** This code translates to initializaing the rules engine DefaultRulesEngine()
            // load up the knowledge base
            //KieServices ks = KieServices.Factory.get();
            //KieContainer kContainer = ks.getKieClasspathContainer();
            //KieSession kSession = kContainer.newKieSession("ksession-rules");
            //KieSession kSession = kContainer.newKieSession("ksession-discoverrules");

            //for (NasVolume volume : volList) {
            //	kSession.insert(volume);
            //}

        	//**** This code is not required as the rule class uses Spring Autowiring
            //kSession.setGlobal("shareService", shareService);
            //kSession.setGlobal("hostService", hostService);
            //kSession.setGlobal("impactService", impactService);
            //kSession.setGlobal("ruleVolumeList", ruleVolumeList);
            //kSession.setGlobal("ruleContIdList", ruleContIdList);//This is for missingRoot
            //kSession.fireAllRules();
            //kSession.dispose();
            
        	
        	//**** This code has been implemented in @Action of the rule class
			//for (NasVolume ruleVolume: ruleVolumeList){
			//	logger.debug("Volume back from rule: "+ruleVolume.toString());
			//	callService(ruleVolume);
			//}            
            
			
			/**
			 * Ashish code start
			 */
			
        	//Create new rules and add existing rules
			Rules rules = new Rules();
			rules.register(new AccessControlRule());
			rules.register(new AgedAccessRule());
			rules.register(new ControllerRootRule());
			rules.register(new DiscoveryRule());
			
			//Create rules engine, iterater through nas volumes and fire rules
			//Big chang here - I am injecting nasvolume as a fact instead of using the setVolume method
			RulesEngine rulesEngine = new DefaultRulesEngine();
			//May need to add NasVolume as a fact if it is required in rules classes
			for (NasVolume volume : volList) {
				Facts facts = new Facts();
				facts.put("nasVolume", volume);
				rulesEngine.fire(rules, facts);
            }
			
			/**
			 * Ashish code ends
			 */

			//FIXME: Make this code work, or replace it work working code.
			 // create facts
	        //Facts facts = new Facts();
	 
	        // create rules
	        //Rules rules = new Rules();
	        //rules.register(new HelloWorldRule());
	 
	        // create a rules engine and fire rules on known facts
	        //RulesEngine rulesEngine = new DefaultRulesEngine();
	        //rulesEngine.fire(rules, facts);
	        // END REPLACE CODE
	        
	        
        } catch (Exception e) {
            e.printStackTrace();
			logger.error("Unable to execute one or more rules",e); 
		}
		logger.info("End drools rule engine in volDisposition");
	}

	private void callService(NasVolume volume) {
		try{
			volService.updateDispositionById(volume.getId(), volume.getDisposition(),volume.getJustification());
			System.out.println("Rule Called service :"+volume.getId());
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("Error in rule Called service :"+e.getMessage());
		}

	}
}
