package com.accsoftware.rest.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.accsoftware.rest.user.User;

@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails {
	
	User u;

	public MyUserDetails(User u) {
		this.u = u;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<>();
		if(u.isAdmin()) {
			SimpleGrantedAuthority sa = new SimpleGrantedAuthority("ROLE_ADMIN");
			list.add(sa);
		}
		else {
			SimpleGrantedAuthority sa = new SimpleGrantedAuthority("ROLE_USER");
			list.add(sa);
		}
		return list;
	}

	@Override
	public String getPassword() {
		return u.getPassword();
	}

	@Override
	public String getUsername() {
		return u.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
}
