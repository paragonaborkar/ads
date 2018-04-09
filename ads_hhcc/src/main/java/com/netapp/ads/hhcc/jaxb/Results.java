package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "results")
public class Results {

	private String status;
	private SystemInfo systemInfo;
	private Vfilers vfilers;
	private InterfaceConfigInfo interfaceConfigInfo;
	private String tag;
	private int records;
	private NfsTop nfsTop;
	private long localTime;
	private long utcTime;
	private CIFSShares cIFSShares;
	private CIFSessions cIFSSessions;
	

	public CIFSessions getcIFSSessions() {
		return cIFSSessions;
	}

	@XmlElement(name = "cifs-sessions")
	public void setcIFSSessions(CIFSessions cIFSSessions) {
		this.cIFSSessions = cIFSSessions;
	}

	public CIFSShares getcIFSShares() {
		return cIFSShares;
	}

	@XmlElement(name = "cifs-shares")
	public void setcIFSShares(CIFSShares cIFSShares) {
		this.cIFSShares = cIFSShares;
	}

	public long getLocalTime() {
		return localTime;
	}

	@XmlElement(name = "local-time")
	public void setLocalTime(long localTime) {
		this.localTime = localTime;
	}

	public long getUtcTime() {
		return utcTime;
	}

	@XmlElement(name = "utc-time")
	public void setUtcTime(long utcTime) {
		this.utcTime = utcTime;
	}

	public NfsTop getNfsTop() {
		return nfsTop;
	}

	@XmlElement(name = "nfs-top")
	public void setNfsTop(NfsTop nfsTop) {
		this.nfsTop = nfsTop;
	}

	public String getTag() {
		return tag;
	}

	@XmlElement(name = "tag")
	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getRecords() {
		return records;
	}

	@XmlElement(name = "records")
	public void setRecords(int records) {
		this.records = records;
	}

	public InterfaceConfigInfo getInterfaceConfigInfo() {
		return interfaceConfigInfo;
	}

	@XmlElement(name = "interface-config-info")
	public void setInterfaceConfigInfo(InterfaceConfigInfo interfaceConfigInfo) {
		this.interfaceConfigInfo = interfaceConfigInfo;
	}

	public Vfilers getVfilers() {
		return vfilers;
	}

	@XmlElement(name = "vfilers")
	public void setVfilers(Vfilers vfilers) {
		this.vfilers = vfilers;
	}

	public String getStatus() {
		return status;
	}

	@XmlElement(name = "status")
	public void setStatus(String status) {
		this.status = status;
	}

	public SystemInfo getSystemInfo() {
		return systemInfo;
	}

	@XmlElement(name = "system-info")
	public void setSystemInfo(SystemInfo systemInfo) {
		this.systemInfo = systemInfo;
	}

}
