package com.netapp.ads.hhcc.vo;

public class ShowmountImportData {

	String shareId;
	String internalVolId;
	String storageId;
	String name;
	String protocol;
	String hostIp;

	public String getShareId() {
		return shareId;
	}

	public void setShareId(String shareId) {
		this.shareId = shareId;
	}

	public String getInternalVolId() {
		return internalVolId;
	}

	public void setInternalVolId(String internalVolId) {
		this.internalVolId = internalVolId;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

}
