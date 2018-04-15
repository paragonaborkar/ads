package com.netapp.ads.pojo;

import java.util.ArrayList;
import java.util.List;

public class ApplicationsPojo {
	private List<ApplicationPojo> applications = new ArrayList<ApplicationPojo>();

	public List<ApplicationPojo> getApplications() {
		return applications;
	}

	public void setApplications(List<ApplicationPojo> applications) {
		this.applications = applications;
	}

	@Override
	public String toString() {
		return "ApplicationsPojo [applications=" + applications + "]";
	}
}