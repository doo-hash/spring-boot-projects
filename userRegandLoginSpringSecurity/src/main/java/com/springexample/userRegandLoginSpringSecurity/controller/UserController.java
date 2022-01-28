package com.springexample.userRegandLoginSpringSecurity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springexample.userRegandLoginSpringSecurity.model.User;
import com.springexample.userRegandLoginSpringSecurity.model.UserRoles;
import com.springexample.userRegandLoginSpringSecurity.service.UserServiceImpl;

@Controller
@RequestMapping("/home")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;

	@GetMapping
	public String homepage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegisterPage(Model model) {
		model.addAttribute("user",new User());
		model.addAttribute("roles",UserRoles.values());
		return "register";
	}
	
	@PostMapping("/register/save")
	public String saveUser(@Valid @ModelAttribute("user") User user,
			BindingResult result,Model model) {
		model.addAttribute("roles",UserRoles.values());
		if(result.hasErrors()) {
			return "register";
		}
		userService.saveUser(user);
		return "redirect:/home/register?success";
	}
	
}
