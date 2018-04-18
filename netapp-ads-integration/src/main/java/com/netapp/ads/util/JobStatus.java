package com.netapp.ads.util;

public enum JobStatus {
	
	IN_PROGRESS("In Progress"),
	FINISHED("Finished");
	
	private String status;
	
	JobStatus(String status) {
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}
