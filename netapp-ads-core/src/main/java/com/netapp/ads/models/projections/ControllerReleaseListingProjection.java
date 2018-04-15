package com.netapp.ads.models.projections;

import java.sql.Timestamp;

import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.Controller;
import com.netapp.ads.models.ControllerRelease;

@Projection(name="ControllerReleaseListing", types = { ControllerRelease.class})
public interface ControllerReleaseListingProjection {
	
	
	public boolean getProcessed();

	public Timestamp getCreateTime();
	
	public Timestamp getUpdateTime();

	public Controller getSrcController();
	public Controller getTgtController();
}
