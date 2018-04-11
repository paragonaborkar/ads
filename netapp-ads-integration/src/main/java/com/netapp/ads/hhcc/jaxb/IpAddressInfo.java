package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class IpAddressInfo {

	private String address;

	private String broadcast;

	private String addrFamily;

	private String netmaskRrPrefix;

	private String creator;

	public String getAddress() {
		return address;
	}

	@XmlElement(name = "address")
	public void setAddress(String address) {
		this.address = address;
	}

	public String getBroadcast() {
		return broadcast;
	}

	@XmlElement(name = "broadcast")
	public void setBroadcast(String broadcast) {
		this.broadcast = broadcast;
	}

	public String getAddrFamily() {
		return addrFamily;
	}

	@XmlElement(name = "addr-family")
	public void setAddrFamily(String addrFamily) {
		this.addrFamily = addrFamily;
	}

	public String getNetmaskRrPrefix() {
		return netmaskRrPrefix;
	}

	@XmlElement(name = "netmask-or-prefix")
	public void setNetmaskRrPrefix(String netmaskRrPrefix) {
		this.netmaskRrPrefix = netmaskRrPrefix;
	}

	public String getCreator() {
		return creator;
	}

	@XmlElement(name = "creator")
	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "ClassPojo [address = " + address + ", broadcast = " + broadcast + ", addrFamily = " + addrFamily
				+ ", netmaskRrPrefix = " + netmaskRrPrefix + ", creator = " + creator + "]";
	}
}
