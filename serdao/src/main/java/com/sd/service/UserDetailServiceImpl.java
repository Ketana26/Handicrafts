package com.sd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.dao.UserDetailDaoInt;
import com.sd.model.UserDetails;
@Service
public class UserDetailServiceImpl implements UserDetailsServiceInt{
	@Autowired
	private UserDetailDaoInt userDetailsDao;
	
	public String addUser(UserDetails ud){
		return userDetailsDao.addUser(ud);
	}
	

}
