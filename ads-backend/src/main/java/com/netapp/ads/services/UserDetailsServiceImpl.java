
package com.netapp.ads.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netapp.ads.config.SecurityConfig;
import com.netapp.ads.config.AdsUser;
import com.netapp.ads.config.AdsUserDetails;
import com.netapp.ads.models.UserApi;
import com.netapp.ads.models.UserCorporate;
import com.netapp.ads.models.UserNative;
import com.netapp.ads.repos.UserApiRepository;
import com.netapp.ads.repos.UserCorporateRepository;
import com.netapp.ads.repos.UserNativeRepository;

@Service
@Transactional(readOnly=false)
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserNativeRepository userNativeRepository;

	@Autowired
	private UserApiRepository userApiRepository;
	
	@Autowired
	private UserCorporateRepository userCorporateRepository;

	/**
	 * Checks Credentials in API and Native Table for Authentication
	 * Issues Token for SSO Login
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		if (username.indexOf("SSO") != -1) {
			String split[] = username.split("-");
			grantedAuthorities.add(new SimpleGrantedAuthority("USER_TYPE"));

			if (SecurityConfig.authAssertionIdUserNameCache.get(split[1]) == null) {
				throw new UsernameNotFoundException(String.format("The user is not enabled", username));
			} else {
				SecurityConfig.authAssertionIdUserNameCache.remove(split[1]);
				UserCorporate userCorporate = userCorporateRepository.findFirstByEmail(split[2]);
				return new AdsUser(split[2],new BCryptPasswordEncoder().encode(split[1]), grantedAuthorities,userCorporate);
			}
		}

		if(!userApiRepository.findByClientId(username).isEmpty()) {
			UserApi userApi = userApiRepository.findByClientId(username).get(0);
			if (userApi.getEnabled()) {
				grantedAuthorities.add(new SimpleGrantedAuthority("CLIENT"));
				return  new AdsUser(userApi.getClientId(), userApi.getClientSecret(), grantedAuthorities, userApi);
			} else {
				throw new UsernameNotFoundException(String.format("The user is not enabled", username));
			}
		} else {
			UserNative userNative = userNativeRepository.findFirstByEmail(username);
			if (userNative == null || !userNative.getEnabled()) {
				throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
			}
			
			// FIXME: Get the user role and return it here. 
			// Frontend needs to be update do that admin menus are not displayed.
			grantedAuthorities.add(new SimpleGrantedAuthority("USER_TYPE"));
			
//			return (User) new User(user.getUserName(), user.getPassword(), grantedAuthorities);
			return  new AdsUser(userNative.getUserName(), userNative.getPassword(), grantedAuthorities,  userNative);
		}
	}

}
