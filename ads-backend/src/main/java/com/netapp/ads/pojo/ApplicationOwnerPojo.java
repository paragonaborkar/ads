package com.netapp.ads.pojo;



public class ApplicationOwnerPojo {
	private static final long serialVersionUID = 1L;
	
	
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String phoneNum;
	private String userName;
	private String costCenter;
	
	private ApplicationOwnerPojo manager;
	
	
	public ApplicationOwnerPojo() {
	}
	
	
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getCostCenter() {
		return this.costCenter;
	}

	public void setCostCenter(String costCenter) {
		this.costCenter = costCenter;
	}
	
	
	
	public ApplicationOwnerPojo getManager() {
		return this.manager;
	}

	public void setManager(ApplicationOwnerPojo manager) {
		this.manager = manager;
	}
	

}