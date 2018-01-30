package com.netapp.ads.projections;

import java.sql.Timestamp;

import org.springframework.data.rest.core.config.Projection;

import com.netapp.ads.models.UserNative;
import com.netapp.ads.models.UserRole;

@Projection(name = "userNativeWithUserRole", types = { UserNative.class })
public interface UserNativeWithUserRole {
	
	String getFirstName();
	String getLastName();
	String getUserName();
	String getEmail();
	boolean getEnabled();

	Timestamp getCreateTime();
	Timestamp getUpdateTime();

	UserRole getUserRole();
}
