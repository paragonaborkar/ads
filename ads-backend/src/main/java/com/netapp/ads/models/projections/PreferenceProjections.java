package com.netapp.ads.models.projections;

import java.util.Date;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.Preference;
import com.netapp.ads.models.PreferenceDetail;

@Projection(name="preferenceWithPreferenceDetails", types = { Preference.class})
public interface PreferenceProjections {
	
	public Date getCreatedOn();

	public String getPageName();

	public String getPreferenceType();

	public Date getUpdatedOn();

	public List<PreferenceDetail> getPreferenceDetails();
}
