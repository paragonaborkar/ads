package com.netapp.ads.hhcc.vo;

public class Credential {

	String adminName;
	String adminPassword;

	public Credential() {

	}

	public Credential(String adminName, String adminPassword) {

		this.adminName = adminName;
		this.adminPassword = adminPassword;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}
