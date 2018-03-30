package com.netapp.ads.models.projections;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.Export;
import com.netapp.ads.models.Host;
import com.netapp.ads.models.MountPoint;
import com.netapp.ads.models.UserCorporate;

@Projection(name="hostWithApplications", types = {Host.class})
public interface HostWithApplications {
	
	public Integer getId();

	public String getHostName();

	public Integer getHostOwnerUserCorporateId();

	public UserCorporate getHostOwnerUserCorporate();

	public String getIpAddr();

	public String getNote() ;

	public Integer getSystemAdminId() ;

	public List<ApplicationWithId> getApplications() ;

	public List<Export> getExports() ;

	public List<MountPoint> getMountPoints();
}
