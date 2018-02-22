/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/
package refactor.services;

import java.util.List;

import com.netapp.ads.exception.NetAppAdsException;
import com.netapp.ads.models.Export;
import com.netapp.ads.models.NasVolume;


// ADS: impact(s) is renamed to exports

public interface ImpactService  {

	 void create(Export entity)  throws NetAppAdsException;
	 Export update(Export entity) throws NetAppAdsException;
	 void deleteById(Export entity) throws NetAppAdsException;
	 Export getById(int id) throws NetAppAdsException;
	 List<Export> getAll() throws NetAppAdsException;
	 List<Export> getByVolume(NasVolume entity) throws NetAppAdsException;
	 List<Export> getByShare(String name) throws NetAppAdsException;
	 List<String> getHostsByShare(String name) throws NetAppAdsException;
}
