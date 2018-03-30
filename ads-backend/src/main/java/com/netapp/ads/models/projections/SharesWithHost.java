package com.netapp.ads.models.projections;

import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.Share;

@Projection(name="sharesWithHostAndApps", types = {Share.class})
public interface SharesWithHost {
	Integer getId();

	Integer getOwnerUserCorporateId();

	String getShareName();

	String getShareType();

	HostWithApplications getHost();

}
