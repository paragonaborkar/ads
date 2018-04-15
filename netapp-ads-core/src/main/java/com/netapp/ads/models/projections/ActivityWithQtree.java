package com.netapp.ads.models.projections;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.Activity;
import com.netapp.ads.models.ActivityResponse;

@Projection(name="activityWithQtree", types = { Activity.class})
public interface ActivityWithQtree {

	public Integer getId();
	
	public boolean getAdminOverride();

	public Timestamp getCreateTime();

	public Date getDecommissionDate();

	public Integer getMigrateDay();

	public Date getMigrateWeek();

	public String getNote();

	public Timestamp getUpdateTime();

	public boolean getWillDecommission();

	public boolean getWillMigrate();
	
	public String getUnidentifiedReason();

	List<ActivityResponse> getActivityResponses();
	
	public QtreeExplodedForActivity getQtree();
	

	//https://stackoverflow.com/questions/28137297/how-to-conditionally-expose-data-in-spring-data-rest-projection
//	Nested Data to be returned goals:
//	Qtrees[]
//			Shares[]
//					Hosts[]
//							Apps[]
	

}
