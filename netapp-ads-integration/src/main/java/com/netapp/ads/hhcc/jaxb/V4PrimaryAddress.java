package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class V4PrimaryAddress {

	private IpAddressInfo ipAddressInfo;

	public IpAddressInfo getIpAddressInfo() {
		return ipAddressInfo;
	}

	@XmlElement(name = "ip-address-info")
	public void setIpAddressInfo(IpAddressInfo ipAddressInfo) {
		this.ipAddressInfo = ipAddressInfo;
	}

	@Override
	public String toString() {
		return "ClassPojo [ipAddressInfo = " + ipAddressInfo + "]";
	}
}
