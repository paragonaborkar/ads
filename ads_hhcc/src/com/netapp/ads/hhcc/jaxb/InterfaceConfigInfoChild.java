package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class InterfaceConfigInfoChild {

	private String ipspaceName;

	private String flowcontrol;

	private String interfaceName;

	private String macAddress;

	private V4PrimaryAddress v4PrimaryAddress;

	private String mediatype;

	public String getIpspaceName() {
		return ipspaceName;
	}

	@XmlElement(name = "ipspace-name")
	public void setIpspaceName(String ipspaceName) {
		this.ipspaceName = ipspaceName;
	}

	public String getFlowcontrol() {
		return flowcontrol;
	}

	@XmlElement(name = "flowcontrol")
	public void setFlowcontrol(String flowcontrol) {
		this.flowcontrol = flowcontrol;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	@XmlElement(name = "interface-name")
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getMacAddress() {
		return macAddress;
	}

	@XmlElement(name = "mac-address")
	public void setMacAddress(String macAddress) {
		this.macAddress = macAddress;
	}

	public V4PrimaryAddress getV4PrimaryAddress() {
		return v4PrimaryAddress;
	}

	@XmlElement(name = "v4-primary-address")
	public void setV4PrimaryAddress(V4PrimaryAddress v4PrimaryAddress) {
		this.v4PrimaryAddress = v4PrimaryAddress;
	}

	public String getMediatype() {
		return mediatype;
	}

	@XmlElement(name = "mediatype")
	public void setMediatype(String mediatype) {
		this.mediatype = mediatype;
	}

	@Override
	public String toString() {
		return "ClassPojo [ipspaceName = " + ipspaceName + ", flowcontrol = " + flowcontrol + ", interfaceName = "
				+ interfaceName + ", macAddress = " + macAddress + ", v4PrimaryAddress = " + v4PrimaryAddress
				+ ", mediatype = " + mediatype + "]";
	}
}
