package com.netapp.ads.hhcc.vo;

public class HostExportData {

	String hostname;
	String ip;
	String export;
	String operations;

	public HostExportData() {
	}

	public HostExportData(String hostname, String ip, String export, String operations) {
		super();
		this.hostname = hostname;
		this.ip = ip;
		this.export = export;
		this.operations = operations;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getExport() {
		return export;
	}

	public void setExport(String export) {
		this.export = export;
	}

	public String getOperations() {
		return operations;
	}

	public void setOperations(String operations) {
		this.operations = operations;
	}

}
