/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/
package com.netapp.ads.rules.engine;

import java.util.List;

import com.netapp.ads.models.Qtree;

public interface ExceptionRuleService {
	
	void executeQtreeExceptionRules(List<Qtree> qtrees);
	 
}
