package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class VfilerInfo {

	private String ipspace;

	private String name;

	private Vfnets vfnets;

	private String uuid;

	private String status;

	public String getStatus() {
		return status;
	}

	@XmlElement(name = "status")
	public void setStatus(String status) {
		this.status = status;
	}

	public String getIpspace() {
		return ipspace;
	}

	@XmlElement(name = "ipspace")
	public void setIpspace(String ipspace) {
		this.ipspace = ipspace;
	}

	public String getName() {
		return name;
	}

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	public Vfnets getVfnets() {
		return vfnets;
	}

	@XmlElement(name = "vfnets")
	public void setVfnets(Vfnets vfnets) {
		this.vfnets = vfnets;
	}

	public String getUuid() {
		return uuid;
	}

	@XmlElement(name = "uuid")
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	@Override
	public String toString() {
		return "ClassPojo [ipspace = " + ipspace + ", name = " + name + ", vfnets = " + vfnets + ", uuid = " + uuid
				+ "]";
	}
}
