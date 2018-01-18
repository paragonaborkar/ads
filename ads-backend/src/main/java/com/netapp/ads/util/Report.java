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
	
	public static void main(String[] args) {
		String password = "123456";
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		// FIXME: no sys out's
		System.out.println(hashedPassword);
	}

}
