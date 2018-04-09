package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class CIFSShares {

	private CIFShareInfo[] cIFShareInfo;

	public CIFShareInfo[] getcIFShareInfo() {
		return cIFShareInfo;
	}

	@XmlElement(name = "cifs-share-info")
	public void setcIFShareInfo(CIFShareInfo[] cIFShareInfo) {
		this.cIFShareInfo = cIFShareInfo;
	}

}
