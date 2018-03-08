package com.netapp.ads.models.projections;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.Controller;
import com.netapp.ads.models.ControllerRelease;
import com.netapp.ads.models.Preference;
import com.netapp.ads.models.PreferenceDetail;

@Projection(name="ControllerReleaseListing", types = { ControllerRelease.class})
public interface ControllerReleaseListingProjection {
	
	
	public boolean getProcessed();

	public Timestamp getCreateTime();
	
	public Timestamp getUpdateTime();

	public Controller getSrcController();
	public Controller getTgtController();
}
