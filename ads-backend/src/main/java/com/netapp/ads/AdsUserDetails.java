package com.netapp.ads;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


public interface AdsUserDetails extends UserDetails {

	
//	public AdsUserDetails(String userName, String password, Set<GrantedAuthority> grantedAuthorities ) {
//		  super(userName, password, grantedAuthorities);
//	}

	
}
