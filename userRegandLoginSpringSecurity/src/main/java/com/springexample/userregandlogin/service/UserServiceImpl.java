package com.springexample.userregandlogin.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexample.userregandlogin.model.User;
import com.springexample.userregandlogin.model.UserDTO;
import com.springexample.userregandlogin.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public String saveUser(UserDTO user) {
		if(user == null) {
			return "user not saved";
		}
		User saveduser = new User(user.getUserid(),user.getFullname(),
				user.getEmail(),
				user.getPassword(), user.isCheckterms());
		userRepo.save(saveduser);
		return saveduser.getUserid();
	}

	@Override
	public User getUser(String userid) {
		return userRepo.findByUserid(userid);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User loadUserByUsername(String username) {
		if(userRepo.existsByUserid(username)) {
			return userRepo.findByUserid(username);
		}
		return null;
	}

	public User getUserById(Long id) {
		return userRepo.findById(id).get();
	}
} 
