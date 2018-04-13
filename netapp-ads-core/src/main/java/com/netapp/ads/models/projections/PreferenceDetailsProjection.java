package com.netapp.ads.models.projections;

import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.Preference;
import com.netapp.ads.models.PreferenceDetail;

@Projection(name="preferenceDetailsWithPreference", types = { PreferenceDetail.class})
public interface PreferenceDetailsProjection {
	
	Integer getCorpUserId();

	String getFieldName();
	String getFieldTemplate();
	Integer getFieldOrder();
	Integer getFieldVisible();
	
	Preference getPreference();

}
