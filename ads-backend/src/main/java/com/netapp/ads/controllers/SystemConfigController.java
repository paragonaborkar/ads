package com.netapp.ads.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netapp.ads.beans.SystemProperty;
import com.netapp.ads.models.SysConfig;
import com.netapp.ads.services.SystemPropertiesService;
import com.netapp.ads.util.ConverterUtil;

@RestController
public class SystemConfigController {

	@Autowired
	private SystemPropertiesService systemPropertiesService;
	
	@RequestMapping(value = "/getSysConfigGroups" , method = RequestMethod.GET)
	public List<String> getGroupName(){
		return systemPropertiesService.findDistinctGroupNames();
	}
	@RequestMapping(value = "/getSysConfigGroups/{grouping}" , method = RequestMethod.GET)
	public List<SystemProperty> getSysConfigByGroup(@PathVariable String grouping){
		List<SysConfig> lstConfigProperties=systemPropertiesService.findByGroupName(grouping);
		return ConverterUtil.convertModelToBean(lstConfigProperties);
	}
}
