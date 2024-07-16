package com.springexample.userregandlogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springexample.userregandlogin.model.User;
import com.springexample.userregandlogin.service.UserServiceImpl;

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
	public String validLogin(@RequestParam String username) {
		User user = userService.loadUserByUsername(username);
		if(user == null) {
			return "redirect:/home/login?error";
		}
		return "redirect:/home/admin/"+user.getId()+"/portal";
	}
				
	@GetMapping("/admin/{id}/portal")
	public String adminportal(@PathVariable Long id,Model model) {
		User user = userService.getUserById(id);
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
	@GetMapping("/user/logout")
	public String logout() {
		return "redirect:/home/login";
	}

}
