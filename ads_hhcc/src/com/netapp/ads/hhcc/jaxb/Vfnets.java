package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class Vfnets {
	private VfnetInfo[] vfnetInfo;

	public VfnetInfo[] getVfnetInfo() {
		return vfnetInfo;
	}

	@XmlElement(name = "vfnet-info")
	public void setVfnetInfo(VfnetInfo[] vfnetInfo) {
		this.vfnetInfo = vfnetInfo;
	}

	@Override
	public String toString() {
		return "ClassPojo [vfnetInfo = " + vfnetInfo + "]";
	}
}