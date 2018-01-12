package com.netapp.ads.services;

import com.netapp.ads.models.UserNative;

public interface UserNativeService {
	
	public Iterable<UserNative> getuser();
	UserNative findByEmail(String email);
}
