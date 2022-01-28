package com.springexample.userRegandLoginSpringSecurity.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springexample.userRegandLoginSpringSecurity.model.Roles;
import com.springexample.userRegandLoginSpringSecurity.model.User;
import com.springexample.userRegandLoginSpringSecurity.repository.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserRepository userRepo;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public String saveUser(User user) {
		System.out.println(user.toString());
		String psd = passwordEncoder.encode(user.getPassword());
		User saveduser = new User(user.getUserid(),user.getFullname(),
				user.getEmail(),
				psd,user.getRoles() , false);
		userRepo.save(saveduser);
		return saveduser.getUserid();
	}

	@Override
	public User getUser(String userid) {
		User user = userRepo.findByUserid(userid);
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepo.findByUserid(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid Username or password");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUserid(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Roles> roles){
		/*
		 * String[] userRoles = user.getRoles().stream().map((role) ->
		 * role.getName()).toArray(String[]::new); Collection<GrantedAuthority>
		 * authorities = AuthorityUtils.createAuthorityList(userRoles); return
		 * authorities;
		 */
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
	}
} 
