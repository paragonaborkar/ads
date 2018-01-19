package com.netapp.ads.converters;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.netapp.ads.models.ControllerPK;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ControllerPKConverter implements Converter<String, ControllerPK> {
    
	@Override
    public ControllerPK convert(String s) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(s, ControllerPK.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
