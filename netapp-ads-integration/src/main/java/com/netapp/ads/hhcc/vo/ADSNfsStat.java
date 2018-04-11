package com.netapp.ads.hhcc.vo;

public class ADSNfsStat {

	String clientInfo;
	int totalOps;

	public ADSNfsStat() {

	}

	public ADSNfsStat(String clientInfo, int totalOps) {

		this.clientInfo = clientInfo;
		this.totalOps = totalOps;
	}

	public String getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(String clientInfo) {
		this.clientInfo = clientInfo;
	}

	public int getTotalOps() {
		return totalOps;
	}

	public void setTotalOps(int totalOps) {
		this.totalOps = totalOps;
	}

}
