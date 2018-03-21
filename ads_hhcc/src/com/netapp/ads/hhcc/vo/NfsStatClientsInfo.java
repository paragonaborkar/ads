package com.netapp.ads.hhcc.vo;

import java.util.List;


public class NfsStatClientsInfo {

	public List<ADSNfsStat> clientInfo;

	public List<ADSNfsStat> getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(List<ADSNfsStat> clientInfo) {
		this.clientInfo = clientInfo;
	}

}
