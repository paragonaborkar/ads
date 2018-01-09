package com.netapp.ads;

import com.netapp.ads.converters.ControllerPKConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class ADSConfiguration extends RepositoryRestConfigurerAdapter {
    @Override
    public void configureConversionService(ConfigurableConversionService conversionService) {
        super.configureConversionService(conversionService);
        conversionService.addConverter(new ControllerPKConverter());
    }
}
