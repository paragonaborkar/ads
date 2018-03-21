package com.netapp.ads.hhcc.vo;

import java.util.List;

public class DataSource {

	String name;
	DataSourceConfig config;
	List<DataSourcePackage> packages;
	
	public List<DataSourcePackage> getPackages() {
		return packages;
	}
	public void setPackages(List<DataSourcePackage> packages) {
		this.packages = packages;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public DataSourceConfig getConfig() {
		return config;
	}
	public void setConfig(DataSourceConfig config) {
		this.config = config;
	}
	
	
	
}
