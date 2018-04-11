package com.netapp.ads.config;

import java.io.IOException;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.Message;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

@Configuration
public class DroolsAutoConfiguration {
	
	private static final Logger log = LoggerFactory.getLogger(DroolsAutoConfiguration.class);
	
	@Value("#{sysConfigRepository.findByPropertyName('ads.rules.rules_path').getPropertyValue()}")
	private String RULES_PATH;
	
	/**
	 * Create Drools Kie Container
	 * 
	 * @return
	 * @throws IOException
	 */
	@Bean
	public KieContainer kieContainer() throws IOException {
		 log.debug("kieContainer: Called");
		
		KieServices kieServices = kieServices();
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
	    for (Resource file : getRuleFiles()) {
	    	log.debug("kieContainer: rules file {} ", file.getFile().getAbsolutePath());
	    	kieFileSystem.write("src/main/resources/rules/" + file.getFilename(), kieServices.getResources().newFileSystemResource(file.getFile()).setResourceType(ResourceType.DRL));
	    }
	    log.debug("kieContainer: Finished adding rules files");
	    KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
	    kieBuilder.buildAll();
	    if (kieBuilder.getResults().hasMessages(Message.Level.ERROR)) {
            List<Message> errors = kieBuilder.getResults().getMessages(Message.Level.ERROR);
            StringBuilder sb = new StringBuilder("Errors:");
            for (Message msg : errors) {
                sb.append("\n  " + msg);
            }
            throw new IOException(sb.toString());
        }

	    KieContainer kieContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());
	    log.debug("kieContainer: Created KieContainer: {}", kieContainer);
	    return kieContainer;
	}
	
	/**
	 * Get Drools Kie Services
	 * 
	 * @return
	 */
	@Bean
	public KieServices kieServices() {
		return KieServices.Factory.get();
	}
	
	/**
	 * Get all rules files from RULES_PATH
	 * 
	 * @return
	 * @throws IOException
	 */
	private Resource[] getRuleFiles() throws IOException {
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		log.info("Loading rules from: {}", RULES_PATH);
		return resourcePatternResolver.getResources(RULES_PATH + "**/*.*");
	}
}
