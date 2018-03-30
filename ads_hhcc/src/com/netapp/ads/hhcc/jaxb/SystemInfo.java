package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class SystemInfo {

	private String systemName;
	private String systemSerialNumber;
	private String systemId;

	public String getSystemId() {
		return systemId;
	}

	@XmlElement(name = "system-id")
	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getSystemName() {
		return systemName;
	}

	@XmlElement(name = "system-name")
	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getSystemSerialNumber() {
		return systemSerialNumber;
	}

	@XmlElement(name = "system-serial-number")
	public void setSystemSerialNumber(String systemSerialNumber) {
		this.systemSerialNumber = systemSerialNumber;
	}

}
