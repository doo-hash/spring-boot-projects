package com.springexample.userRegandLoginSpringSecurity.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.springexample.userRegandLoginSpringSecurity.model.User;

public interface IUserService extends UserDetailsService{

	public String saveUser(User user);
	
	public User getUser(String userid);
	
	public List<User> getAllUsers();
	
}
