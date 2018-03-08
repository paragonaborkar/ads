package com.netapp.ads.models.projections;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.Controller;
import com.netapp.ads.models.ControllerTargetsAvailable;

@Projection(name="ControllerTargetListing", types = { ControllerTargetsAvailable.class})
public interface ControllerTargetListingProjection {

	public String getAssetNumber();

	public Date getControllerInstalledDate();

	public Integer getPriority();

	public String getTargetGroupName();

	public boolean getProcessed();

	public Timestamp getCreateTime();

	public Timestamp getUpdateTime();


	public Controller getController();
}
