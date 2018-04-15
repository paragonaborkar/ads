package com.netapp.ads.models.projections;

import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.Application;
import com.netapp.ads.models.LineOfBusiness;

@Projection(name="applicationWithAllAttributes", types = {Application.class})
public interface ApplicationWithId {
	Integer getId();

	String getApplicationCode() ;

	String getApplicationName();

	String getArchtype() ;
	
	String getInformationOwner();

	Integer getOwnerUserCorporateId();

	List<LineOfBusiness> getLineOfBusinesses() ;

}
