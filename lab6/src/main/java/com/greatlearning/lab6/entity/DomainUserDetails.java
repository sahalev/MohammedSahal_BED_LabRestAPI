package com.greatlearning.lab6.entity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class DomainUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String username;
	private final String password;
	private final List<GrantedAuthority> authorities;
	
	public DomainUserDetails(User user)
	{
		this.username=user.getUserName();
		this.password=user.getPassword();
		this.authorities= user
							.getRoles()
							.stream()
							.map(role -> role.getName())
							.map(roleName->"ROLE_"+roleName)
							.map(SimpleGrantedAuthority::new)
							.collect(Collectors.toList());
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		System.out.println("Printing the authorities ::");
		System.out.println(this.authorities);
		return this.authorities;
	}



	@Override
	public boolean isAccountNonExpired() {
		return true;
		
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	
	
	
}
