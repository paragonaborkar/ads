/*******************************************************************************
 * Copyright (c) 2016 NetApp Inc. All Rights Reserved
 *
 * CONFIDENTIALITY NOTICE: 
 *     THIS SOFTWARE CONTAINS CONFIDENTIAL INFORMATION OF 
 *     NETAPP, INC. USE, DISCLOSURE OR REPRODUCTION IS PROHIBITED 
 *     WITHOUT THE PRIOR EXPRESS WRITTEN PERMISSION OF NETAPP, INC.
 *******************************************************************************/
package refactor.ruleEngine;

import java.util.List;

import com.netapp.ads.models.Controller;

public interface ExceptionRuleService {
	
//	 void exceptionRule(List<CtrlReleaseEntity> crList);
//	 void fireDroolsExceptionRule(List<CtrlReleaseEntity> crList);
	 
	 void exceptionRule(List<Controller> controllers);
	 void fireDroolsExceptionRule(List<Controller> controllers);
	 
}
