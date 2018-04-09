package com.netapp.ads.hhcc.vo;

import java.util.List;

public class DataSourcePackage {

	String id;
	List<DataSourceAttribute> attributes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<DataSourceAttribute> getAttributes() {
		return attributes;
	}

	public void setAttributes(List<DataSourceAttribute> attributes) {
		this.attributes = attributes;
	}

}
