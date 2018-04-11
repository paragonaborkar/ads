package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class VfnetInfo {

	private String ipaddress;

	private String interfaceName;

	private String netmask;

	public String getIpaddress() {
		return ipaddress;
	}

	@XmlElement(name = "ipaddress")
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}

	public String getInterface() {
		return interfaceName;
	}

	@XmlElement(name = "interface")
	public void setInterface(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getNetmask() {
		return netmask;
	}

	@XmlElement(name = "netmask")
	public void setNetmask(String netmask) {
		this.netmask = netmask;
	}

	@Override
	public String toString() {
		return "ClassPojo [ipaddress = " + ipaddress + ", interface = " + interfaceName + ", netmask = " + netmask
				+ "]";
	}
}
