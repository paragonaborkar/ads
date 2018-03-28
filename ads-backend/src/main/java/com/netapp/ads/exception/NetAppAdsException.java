package com.netapp.ads.exception;

public class NetAppAdsException extends RuntimeException {

	/**
	 * Custom Exception
	 */
	private static final long serialVersionUID = 1L;
	public String errorDescription;

	public NetAppAdsException(String errorDescription) {
		super();
		this.errorDescription = errorDescription;
	}
	
}
