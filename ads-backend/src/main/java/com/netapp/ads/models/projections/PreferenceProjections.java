package com.netapp.ads.models.projections;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.Preference;
import com.netapp.ads.models.PreferenceDetail;

@Projection(name="preferenceWithPreferenceDetails", types = { Preference.class})
public interface PreferenceProjections {
	
	
	public String getPageName();

	public String getPreferenceType();
	
	public Integer getCorpUserId();

	public Integer getNativeUserId();

	public Timestamp getCreateTime();
	
	public Timestamp getUpdateTime();

	public List<PreferenceDetail> getPreferenceDetails();
}
