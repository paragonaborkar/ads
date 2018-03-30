package com.netapp.ads.hhcc.vo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CombinedActiveExports {

	String systemName;
	String systemId;
	String systemSerialNumber;
	Timestamp lastSeen;

	List<HostExportData> exportList = new ArrayList<>();
	List<HostExportData> inactiveHosts = new ArrayList<>();

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getSystemSerialNumber() {
		return systemSerialNumber;
	}

	public void setSystemSerialNumber(String systemSerialNumber) {
		this.systemSerialNumber = systemSerialNumber;
	}

	public Timestamp getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(Timestamp lastSeen) {
		this.lastSeen = lastSeen;
	}

	public List<HostExportData> getExportList() {
		return exportList;
	}

	public void setExportList(List<HostExportData> exportList) {
		this.exportList = exportList;
	}

	public List<HostExportData> getInactiveHosts() {
		return inactiveHosts;
	}

	public void setInactiveHosts(List<HostExportData> inactiveHosts) {
		this.inactiveHosts = inactiveHosts;
	}

}
