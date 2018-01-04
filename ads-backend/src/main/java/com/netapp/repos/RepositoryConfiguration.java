package com.netapp.repos;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import com.netapp.models.Host;
import com.netapp.models.MigrationProject;

@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    	
    	// IMPORTANT: DO NOT DO THIS. USE THIS LINKS WITH IDs INCLUDED IN THE JSON
		// config.exposeIdsFor(Host.class);
    	// config.exposeIdsFor(MigrationProject.class);
    }
}