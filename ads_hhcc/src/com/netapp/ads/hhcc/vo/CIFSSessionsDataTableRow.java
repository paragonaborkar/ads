package com.netapp.ads.hhcc.vo;

import java.sql.Timestamp;

public class CIFSSessionsDataTableRow {

	Timestamp dateTime;
	String controllerName;
	String serialNumber;
	String vFileName;
	String vFilerUuid;
	String volumeName;
	String shareName;
	String mountPoint;
	String hostIp;
	String hostName;
	String windowUser;
	String unixUser;
	
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public String getControllerName() {
		return controllerName;
	}
	public void setControllerName(String controllerName) {
		this.controllerName = controllerName;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getvFileName() {
		return vFileName;
	}
	public void setvFileName(String vFileName) {
		this.vFileName = vFileName;
	}
	public String getvFilerUuid() {
		return vFilerUuid;
	}
	public void setvFilerUuid(String vFilerUuid) {
		this.vFilerUuid = vFilerUuid;
	}
	public String getVolumeName() {
		return volumeName;
	}
	public void setVolumeName(String volumeName) {
		this.volumeName = volumeName;
	}
	public String getShareName() {
		return shareName;
	}
	public void setShareName(String shareName) {
		this.shareName = shareName;
	}
	public String getMountPoint() {
		return mountPoint;
	}
	public void setMountPoint(String mountPoint) {
		this.mountPoint = mountPoint;
	}
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	public String getWindowUser() {
		return windowUser;
	}
	public void setWindowUser(String windowUser) {
		this.windowUser = windowUser;
	}
	public String getUnixUser() {
		return unixUser;
	}
	public void setUnixUser(String unixUser) {
		this.unixUser = unixUser;
	}
	
	
}
