package com.netapp.ads.pojo;

import java.util.List;

public class ApplicationsPojo {
	private List<ApplicationPojo> applications;

	public List<ApplicationPojo> getApplications() {
		return applications;
	}

	public void setApplications(List<ApplicationPojo> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "ApplicationWrapper [applications=" + applications + "]";
	}
}