package com.netapp.ads.util;

import java.util.ArrayList;
import java.util.List;

import com.netapp.ads.beans.SystemProperty;
import com.netapp.ads.models.SysConfig;

public class ConverterUtil {

	public static List<SystemProperty> convertModelToBean(List<SysConfig> lstSysConfig) {
		List<SystemProperty> lstSystemProperties = new ArrayList<>();
		for (SysConfig sysConfig : lstSysConfig) {
			SystemProperty systemProperty = new SystemProperty(sysConfig.getId(), sysConfig.getCreateTime(),
					sysConfig.getEncrypted(), sysConfig.getPropertyName(), sysConfig.getPropertyValue(),
					sysConfig.getUpdateTime(), sysConfig.getGrouping(),
					sysConfig.getSysConfigPropertyType().getPropertyType());
			lstSystemProperties.add(systemProperty);
		}
		return lstSystemProperties;

	}
}
