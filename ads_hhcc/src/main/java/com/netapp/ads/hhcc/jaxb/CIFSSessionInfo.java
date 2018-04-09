package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class CIFSSessionInfo {

	String hostName;
	String hostIp;
	String user;
	String shares;
	String files;
	String dirs;
	String changeNotifies;
	VolumesList volumeList;
	
	public VolumesList getVolumeList() {
		return volumeList;
	}

	
	@XmlElement(name = "volumes-list")
	public void setVolumeList(VolumesList volumeList) {
		this.volumeList = volumeList;
	}

	public String getHostName() {
		return hostName;
	}
	
	@XmlElement(name = "host-name")
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getHostIp() {
		return hostIp;
	}
	
	@XmlElement(name = "host-ip")
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public String getUser() {
		return user;
	}
	
	@XmlElement(name = "user")
	public void setUser(String user) {
		this.user = user;
	}
	public String getShares() {
		return shares;
	}
	
	@XmlElement(name = "shares")
	public void setShares(String shares) {
		this.shares = shares;
	}
	public String getFiles() {
		return files;
	}
	
	@XmlElement(name = "files")
	public void setFiles(String files) {
		this.files = files;
	}
	public String getDirs() {
		return dirs;
	}
	
	@XmlElement(name = "dirs")
	public void setDirs(String dirs) {
		this.dirs = dirs;
	}
	public String getChangeNotifies() {
		return changeNotifies;
	}
	
	@XmlElement(name = "change-notifies")
	public void setChangeNotifies(String changeNotifies) {
		this.changeNotifies = changeNotifies;
	}
	
}
