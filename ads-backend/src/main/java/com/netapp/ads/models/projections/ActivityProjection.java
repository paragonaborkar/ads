package com.netapp.ads.models.projections;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.Aggregate;
import com.netapp.ads.models.Controller;
import com.netapp.ads.models.DataCenter;
import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.PreferenceDetail;
import com.netapp.ads.models.Qtree;

@Projection(name="activityWithQtree", types = { Activity.class})
public interface ActivityProjection {
	public boolean getAdminOverride();

	public String getAppNameList();

	public boolean getArchiveCandidate();

	public String getBestNumber();

	public boolean getCallMe();

	public String getCallReason();
	
	public Timestamp getCreateTime();

	public Date getDeleteDate();

	public String getDisposition();

	public boolean getIsLatest();

	public Integer getMailCount();

	public Date getMailingDate();

	public Integer getMigrateDay();

	public Date getMigrateWeek();

	public String getNote();

	public Timestamp getUpdateTime();

	public String getVserver();

	public boolean getWillDelete();

	public boolean getWillMigrate();

	
	public List<Qtree> getQtree();
	
	//Projection specifically created for this method which gets Controller as well as Data Center for a NAS Volume
//	@Value("#{target.getController().getDataCenter()}")
//	DataCenter getDataCenter();
	
}
