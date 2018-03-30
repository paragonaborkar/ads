package com.netapp.ads.models.projections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.UserCorporate;

@Projection(name="UserCorporate", types = { UserCorporate.class})
public interface UserCorporateProjection {

	public Integer getId();

	public String getBestPhone();

	public String getcostCenter();

	public String getEmail();

	public String getFirstName();

	public String getLastName();

	public String getLocation();

	public String getMiddleName();

	public String getMobilePhone();

	public String getTimezone();

	public String getTitle();

	public String getUserName();

	public String getWorkPhone();

	@Value("#{target.firstName} #{target.lastName}") 
	String getFullName();

}
