
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
import com.netapp.ads.models.UserApi;
import com.netapp.ads.models.UserNative;
import com.netapp.ads.repos.UserApiRepository;
import com.netapp.ads.repos.UserNativeRepository;

@Service
@Transactional(readOnly=false)
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserNativeRepository userNativeRepository;

	@Autowired
	private UserApiRepository userApiRepository;

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
				return new org.springframework.security.core.userdetails.User(split[2],
						new BCryptPasswordEncoder().encode(split[1]), grantedAuthorities);
			}
		}

		if(!userApiRepository.findByClientId(username).isEmpty()) {
			UserApi userApi = userApiRepository.findByClientId(username).get(0);
			if (userApi.getEnabled()) {
				grantedAuthorities.add(new SimpleGrantedAuthority("CLIENT"));
				return new User(userApi.getClientId(), userApi.getClientSecret(), grantedAuthorities);
			} else {
				throw new UsernameNotFoundException(String.format("The user is not enabled", username));
			}
		} else {
			UserNative user = userNativeRepository.findFirstByEmail(username);
			if (user == null || !user.getEnabled()) {
				throw new UsernameNotFoundException(String.format("The username %s doesn't exist", username));
			}
			
			// FIXME: Get the user role and return it here. 
			// Frontend needs to be update do that admin menus are not displayed.
			grantedAuthorities.add(new SimpleGrantedAuthority("USER_TYPE"));
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), grantedAuthorities);
		}
	}

}
