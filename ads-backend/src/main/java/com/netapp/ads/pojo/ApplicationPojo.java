package com.netapp.ads.pojo;



public class ApplicationPojo {
	private static final long serialVersionUID = 1L;
	
	
	private String appName;
	private String appCode;
	private String informationOwner;
	
	

	public ApplicationPojo() {
	}

	
	
	public String getAppName() {
		return this.appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	
	public String getAppCode() {
		return this.appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	
	public String getInformationOwner() {
		return this.informationOwner;
	}

	public void setInformationOwner(String informationOwner) {
		this.informationOwner = informationOwner;
	}

}