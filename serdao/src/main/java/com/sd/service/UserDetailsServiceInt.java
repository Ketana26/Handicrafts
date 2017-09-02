package com.sd.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sd.model.UserDetails;

public interface UserDetailsServiceInt {
	@Autowired
	String addUser(UserDetails ud);
	
}
