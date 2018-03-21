package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class NfsTop {

	NfsTopInfo[] nfsTopInfo;

	public NfsTopInfo[] getNfsTopInfo() {
		return nfsTopInfo;
	}

	@XmlElement(name = "nfs-top-info")
	public void setNfsTopInfo(NfsTopInfo[] nfsTopInfo) {
		this.nfsTopInfo = nfsTopInfo;
	}
	
}
