package com.beep.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class DetailsService implements UserDetailsService{

	// This is not our User, this is someone that implements UserDetails (spring)
	
	@Autowired
	UserRepository users;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stubz
		User user = users.findByUserName(username);
		if (user == null){
			throw new UsernameNotFoundException(username + " was not found");
		}
		return new org.springframework.security.core.userdetails.User(
				user.getUserName(),
				user.getPassword(),
				AuthorityUtils.createAuthorityList(user.getRoles())
				);
	}

}
