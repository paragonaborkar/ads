package com.netapp.ads.models.projections;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.ActivityResponse;
import com.netapp.ads.models.Controller;
import com.netapp.ads.models.ControllerRelease;
import com.netapp.ads.models.ControllerWorkPackage;

@Projection(name="ControllerWorkPackageListing", types = { ControllerWorkPackage.class})
public interface ControllerWorkPackageProjection {

	public String getAssetNumber();

	public Date getControllerInstalledDate();

	public Integer getPriority();

	public String getWorkPackageName();

	public boolean getProcessed();

	public Timestamp getCreateTime();

	public Timestamp getUpdateTime();


	public Controller getController();
	
	@Value("#{target.getController().getControllerRelease()}")
	ControllerRelease getControllerRelease();
}
