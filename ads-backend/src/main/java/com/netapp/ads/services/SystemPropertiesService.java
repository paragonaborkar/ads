package com.netapp.ads.services;

import java.util.List;

import com.netapp.ads.models.SysConfig;

public interface SystemPropertiesService {

	List<String> findDistinctGroupNames();

	List<SysConfig> findByGroupName(String grouping);
}
