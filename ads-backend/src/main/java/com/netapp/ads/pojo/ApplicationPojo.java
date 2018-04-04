package com.netapp.ads.pojo;

public class ApplicationPojo {
	private static final long serialVersionUID = 1L;
	private String name;
	private String code;
	private String informationOwner;
	private String owningLOB;
	private ApplicationOwnerPojo owner;
	

	public ApplicationPojo() {
	}

		
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getOwningLOB() {
		return owningLOB;
	}


	public void setOwningLOB(String owningLOB) {
		this.owningLOB = owningLOB;
	}

	public String getCode() {
		return this.code;
	}

	public void setAppCode(String code) {
		this.code = code;
	}
	
	public String getInformationOwner() {
		return this.informationOwner;
	}

	public void setInformationOwner(String informationOwner) {
		this.informationOwner = informationOwner;
	}
	
	public ApplicationOwnerPojo getOwner() {
		return this.owner;
	}

	public void setOwner(ApplicationOwnerPojo owner) {
		this.owner = owner;
	}


	@Override
	public String toString() {
		return "ApplicationPojo [name=" + name + ", code=" + code + ", informationOwner=" + informationOwner
				+ ", owningLOB=" + owningLOB + ", owner=" + owner + "]";
	}
	
	
}