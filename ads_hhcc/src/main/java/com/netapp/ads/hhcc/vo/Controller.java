package com.netapp.ads.hhcc.vo;

public class Controller {

	String name;
	Credential credential;
	String vFilerName;
	int port;

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getvFilerName() {
		return vFilerName;
	}

	public void setvFilerName(String vFilerName) {
		this.vFilerName = vFilerName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Credential getCredential() {
		return credential;
	}

	public void setCredential(Credential credential) {
		this.credential = credential;
	}
}