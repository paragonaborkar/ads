package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class NfsTopInfo {

	int totalOps;
	String clientInfo;

	public int getTotalOps() {
		return totalOps;
	}

	@XmlElement(name = "total-ops")
	public void setTotalOps(int totalOps) {
		this.totalOps = totalOps;
	}

	public String getClientInfo() {
		return clientInfo;
	}

	@XmlElement(name = "client-info")
	public void setClientInfo(String clientInfo) {
		this.clientInfo = clientInfo;
	}

}
