package com.netapp.ads.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Report {
	
	private Integer totalPages;
	private String report;
	
	
	public Integer getTotalPages() {
		return totalPages;
	}
	
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	
	public String getReport() {
		return report;
	}
	
	public void setReport(String report) {
		this.report = report;
	}

}
