package refactor.ruleEngine;
/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/


import java.util.List;

import com.netapp.ads.models.NasVolume;

public interface  VolumeDispositionService{

	 void volDisposition(List<NasVolume> list);
	 void fireDroolsRules(List<NasVolume> list);
}
