package com.springexample.userRegandLoginSpringSecurity.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springexample.userRegandLoginSpringSecurity.service.UserServiceImpl;

@Controller
@RequestMapping("/home")
public class LoginController {

	@Autowired
	private UserServiceImpl userService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String validLogin(@PathVariable String username,
			@PathVariable String password) {
		User user = (User) userService.loadUserByUsername(username);
		Collection<GrantedAuthority> authorities = user.getAuthorities();
		
		for (GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equals("ADMIN")) {
				return "redirect:/home/admin/portal";
			}
		}
		return "redirect:/home/user/portal";
	}
			
	@GetMapping("/user/portal")
	public String portal(Authentication authentication,Model model) {
		String userid = authentication.getName();
		com.springexample.userRegandLoginSpringSecurity.model.User user = userService.getUser(userid);
		model.addAttribute("user",user);
		return "userportal";
	}
	
	@GetMapping("/user/profile")
	public String profile() {
		return "profile";
	}
	
	@GetMapping("/user/notifications")
	public String notifications() {
		return "notifications";
	}
	
	@GetMapping("/user/settings")
	public String settings() {
		return "settings";
	}
	@GetMapping("/admin/portal")
	public String adminportal(Authentication authentication,Model model) {
		String adminid = authentication.getName();
		System.out.println(adminid);
		com.springexample.userRegandLoginSpringSecurity.model.User user = userService.getUser(adminid);
		System.out.println(user);
		model.addAttribute("admin",user);
		return "adminportal";
	}
	
	@GetMapping("/admin/profile")
	public String adminprofile() {
		return "profile";
	}
	
	@GetMapping("/admin/notifications")
	public String adminnotifications() {
		return "notifications";
	}
	
	@GetMapping("/admin/settings")
	public String adminsettings() {
		return "settings";
	}
}
