package com.netapp.ads.pojo;



public class ApplicationsPojo {
	private static final long serialVersionUID = 1L;
	
	
	private ApplicationPojo[] apps;
	

	public ApplicationsPojo() {
	}

	public ApplicationPojo[] getApps() {
		return this.apps;
	}

	public void setApps(ApplicationPojo app) {
		this.apps[apps.length] = app;
	}
	
	
}