package com.netapp.ads.hhcc.vo;

import java.util.ArrayList;
import java.util.List;

public class CombinedActiveExports {

	String netAppSystemName;
	String netAppSystemId;
	String netAppSystemSerial;
	String lastSeen;


	List<HostExportData> exportList = new ArrayList<>();
	List<HostExportData> inactiveHosts = new ArrayList<>();

	public String getNetAppSystemName() {
		return netAppSystemName;
	}

	public void setNetAppSystemName(String netAppSystemName) {
		this.netAppSystemName = netAppSystemName;
	}

	public String getNetAppSystemId() {
		return netAppSystemId;
	}

	public void setNetAppSystemId(String netAppSystemId) {
		this.netAppSystemId = netAppSystemId;
	}

	public String getNetAppSystemSerial() {
		return netAppSystemSerial;
	}

	public void setNetAppSystemSerial(String netAppSystemSerial) {
		this.netAppSystemSerial = netAppSystemSerial;
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
