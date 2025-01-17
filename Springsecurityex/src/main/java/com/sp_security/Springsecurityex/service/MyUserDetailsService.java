package com.sp_security.Springsecurityex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sp_security.Springsecurityex.entity.UserPrincipal;
import com.sp_security.Springsecurityex.entity.Users;
import com.sp_security.Springsecurityex.repo.UserRepo;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Users user =repo.findByUsername(username);
		
		if (user == null) {

			System.out.println("User Not Found");
			throw new UsernameNotFoundException("user not found");
			}
		
		return new UserPrincipal(user);
	}

}
