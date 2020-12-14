package com.accsoftware.rest.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.accsoftware.rest.user.User;
import com.accsoftware.rest.user.UserService;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserService us;

	@Override
	public UserDetails loadUserByUsername(String uname) throws UsernameNotFoundException {
		Optional<User> o = us.fetchByUsername(uname);
		o.orElseThrow( () -> new UsernameNotFoundException("Username :  " + uname + "not found."));
		MyUserDetails ud = new MyUserDetails(o.get());
		return ud;
	}
	
	
}
