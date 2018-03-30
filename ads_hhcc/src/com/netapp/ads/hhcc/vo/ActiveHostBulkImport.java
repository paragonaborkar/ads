package com.netapp.ads.hhcc.vo;

public class ActiveHostBulkImport {

	String protocol;
	String hostId;
	String hostIp;
	String storageId;
	String nfsOps;

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getHostId() {
		return hostId;
	}

	public void setHostId(String hostId) {
		this.hostId = hostId;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public String getStorageId() {
		return storageId;
	}

	public void setStorageId(String storageId) {
		this.storageId = storageId;
	}

	public String getNfsOps() {
		return nfsOps;
	}

	public void setNfsOps(String nfsOps) {
		this.nfsOps = nfsOps;
	}

}
