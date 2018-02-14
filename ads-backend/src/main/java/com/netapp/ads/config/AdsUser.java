package com.netapp.ads.config;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.netapp.ads.models.UserApi;
import com.netapp.ads.models.UserNative;

public class AdsUser extends User {

	private String firstName = "";
	private String lastName = "";
	private String email = "";
	private int nativeUserId = 0;
	private int corpUserId = 0;
	private int apiUserId = 0;

	
	public AdsUser(String username, String password, Collection<GrantedAuthority> authorities, UserNative user) {
		super(username, password, authorities);
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.nativeUserId = user.getId();
	}

	public AdsUser(String username, String password, Collection<GrantedAuthority> authorities, UserApi userApi) {
		super(username, password, authorities);
	}


	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public int getNativeUserId() {
		return this.nativeUserId;
	}

	public int getCorpUserId() {
		return this.corpUserId;
	}

}