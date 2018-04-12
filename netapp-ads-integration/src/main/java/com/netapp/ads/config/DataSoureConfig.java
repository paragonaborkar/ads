package com.netapp.ads.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DataSoureConfig {
	
	@Primary
	@Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
	
	@Bean(name = "ociDataSource")
    @ConfigurationProperties("oci.datasource")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }
	
	@Bean(name = "ociJdbcTemplate")
	@Autowired
	public JdbcTemplate ociJdbcTemplate(@Qualifier("ociDataSource") DataSource dsSlave) {
	    return new JdbcTemplate(dsSlave);
	}
}
