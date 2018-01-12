package com.netapp.ads.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netapp.ads.models.UserNative;
import com.netapp.ads.repos.UserNativeRepository;

@Service("userNativeService")
public class UserNativeServiceImpl implements UserNativeService {
	
	@Autowired
    UserNativeRepository userNativeRepository;
	
	@Override
    @Transactional(readOnly = true)
    public UserNative findByEmail(String email) throws UsernameNotFoundException {
        return userNativeRepository.findByEmail(email).get(0);
    }
	
	@Override
	public Iterable<UserNative> getuser() {
		Iterable<UserNative> s = userNativeRepository.findAll();
		return s;
		
	}
	
}
