package com.netapp.ads.services;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netapp.ads.repos.SysConfigRepository;

@Service
public class SystemPropertiesServiceImpl implements SystemPropertiesService {

	@Autowired
	private SysConfigRepository sysConfigRepository;

	@Override
	public List<String> findDistinctGroupNames() {
		try {
			return sysConfigRepository.findDistinctGroupNames();
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
}