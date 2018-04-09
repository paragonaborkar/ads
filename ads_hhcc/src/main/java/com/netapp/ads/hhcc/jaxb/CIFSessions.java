package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class CIFSessions {

	CIFSSessionInfo cifsSessionInfo[];

	public CIFSSessionInfo[] getCifsSessionInfo() {
		return cifsSessionInfo;
	}

	@XmlElement(name = "cifs-session-info")
	public void setCifsSessionInfo(CIFSSessionInfo[] cifsSessionInfo) {
		this.cifsSessionInfo = cifsSessionInfo;
	}
	
	
}
