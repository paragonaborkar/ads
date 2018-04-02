package com.netapp.ads.hhcc.vo;

public class HostExportData {

	String host;
	String ip;
	String export;
	String operations;

	public HostExportData() {
	}

	public HostExportData(String hostname, String ip, String export, String operations) {
		super();
		this.host = hostname;
		this.ip = ip;
		this.export = export;
		this.operations = operations;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String hostname) {
		this.host = hostname;
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
