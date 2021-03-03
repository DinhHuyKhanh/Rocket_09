package com.vti.service;

import com.vti.entity.User;

public interface IUserService {
	
	public User getUserByID(short id);
	public User getUserByName(String name);

}
