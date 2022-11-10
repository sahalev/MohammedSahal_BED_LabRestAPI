package com.greatlearning.lab6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.lab6.dao.UserRepository;
import com.greatlearning.lab6.entity.DomainUserDetails;
import com.greatlearning.lab6.entity.User;



@Service
public class DomainUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepository.findByUserName(username).orElseThrow(()->(new UsernameNotFoundException(username+"Not foud")));
		System.out.println("User from the repository");
		System.out.println(user);
		return new DomainUserDetails(user);
	}

}
