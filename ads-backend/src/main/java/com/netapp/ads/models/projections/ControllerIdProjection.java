package com.netapp.ads.models.projections;

import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.Controller;

@Projection(name="ControllerId", types = { Controller.class})
public interface ControllerIdProjection {
	
	
	public Integer getId();
	public String getControllerName();
	

	
}
