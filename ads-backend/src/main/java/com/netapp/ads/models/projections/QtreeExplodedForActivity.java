package com.netapp.ads.models.projections;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.NasVolume;
import com.netapp.ads.models.Qtree;
import com.netapp.ads.models.QtreeDisposition;

@Projection(name="qtreeExplodedForActivity", types = {Qtree.class})
public interface QtreeExplodedForActivity {
	
	Integer getId();

	String getQtreeName();

	String getQtreeStatus();

	String getQtreeType();
	
	BigInteger getQuotaHardCapacityLimitMb();

	BigInteger getQuotaSoftCapacityLimitMb(); 

	BigInteger getQuotaUsedCapacityLimitMb();

	String getSecurityStyle();

	NasVolume getNasVolume();

	List<SharesWithHost> getShares();

	Date getLastAccessed();

	List<QtreeDisposition> getQtreeDisposition();
}
