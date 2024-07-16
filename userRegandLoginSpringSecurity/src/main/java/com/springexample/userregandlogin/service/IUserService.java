package com.springexample.userregandlogin.service;

import java.util.List;

import com.springexample.userregandlogin.model.User;
import com.springexample.userregandlogin.model.UserDTO;

public interface IUserService{

	public String saveUser(UserDTO user);
	
	public User getUser(String userid);
	
	public List<User> getAllUsers();
	
}
