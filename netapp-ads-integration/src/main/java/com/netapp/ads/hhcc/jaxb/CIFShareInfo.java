package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class CIFShareInfo {

	String shareName;
	String mountPoint;
	String description;

	public String getShareName() {
		return shareName;
	}

	@XmlElement(name = "share-name")
	public void setShareName(String shareName) {
		this.shareName = shareName;
	}

	public String getMountPoint() {
		return mountPoint;
	}

	@XmlElement(name = "mount-point")
	public void setMountPoint(String mountPoint) {
		this.mountPoint = mountPoint;
	}

	public String getDescription() {
		return description;
	}

	@XmlElement(name = "description")
	public void setDescription(String description) {
		this.description = description;
	}

}
