package com.netapp.ads.models.projections;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.Aggregate;
import com.netapp.ads.models.Controller;
import com.netapp.ads.models.DataCenter;
import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.Qtree;

@Projection(name="withControllerWithDataCenter", types = { NasVolume.class})
public interface NasVolumeProjection {
	Integer getAllocatedCapacityGb();

	Integer getAvgIops();

	Timestamp getCreateTime();
	
	String getDisposition();

	String getJustification();

	Integer getPeakIops();
	
	Integer getQtreeTally();

	String getSnapDestinationVolume() ;

	Integer getSnapSrcVolumeId() ;

	Integer getSnapTally() ;

	Integer getSnapTgtVolumeId();

	String getSnapType() ;

	Timestamp getUpdateTime() ;

	Integer getUsedCapacityGb() ;

	Date getVolumeLastAccessed();

	String getVolumeName() ;

	String getVolumeStatus();

	String getVserver();

	Aggregate getAggregate() ;

	Controller getController() ;

	List<Qtree> getQtrees() ;
	
	//Projection specifically created for this method which gets Controller as well as Data Center for a NAS Volume
	@Value("#{target.getController().getDataCenter()}")
	DataCenter getDataCenter();
	
}
