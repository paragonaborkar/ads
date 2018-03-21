package com.netapp.ads.hhcc.jaxb;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(
		name="results")
public class Results {

	private String status;
	private SystemInfo systemInfo;
	private Vfilers vfilers;
	private InterfaceConfigInfo interfaceConfigInfo;
	private String tag;
	private int records;
	private NfsTop nfsTop;

	
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
