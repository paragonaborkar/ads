package com.netapp.ads.hhcc.vo;

import java.util.ArrayList;
import java.util.List;

public class CurrentNFSMountedHosts {

	String netAppSystemName;
	String netAppSystemId;
	String netAppSystemSerialNumber;
	String lastSeen;

	List<HostExportData> exportList = new ArrayList<>();

	public String getNetAppSystemName() {
		return netAppSystemName;
	}

	public void setNetAppSystemName(String systemName) {
		this.netAppSystemName = systemName;
	}

	public String getNetAppSystemId() {
		return netAppSystemId;
	}

	public void setNetAppSystemId(String systemId) {
		this.netAppSystemId = systemId;
	}

	public String getNetAppSystemSerialNumber() {
		return netAppSystemSerialNumber;
	}

	public void setNetAppSystemSerialNumber(String systemSerialNumber) {
		this.netAppSystemSerialNumber = systemSerialNumber;
	}

	public String getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(String lastSeen) {
		this.lastSeen = lastSeen;
	}

	public List<HostExportData> getExportList() {
		return exportList;
	}

	public void setExportList(List<HostExportData> activeHosts) {
		this.exportList = activeHosts;
	}

}
