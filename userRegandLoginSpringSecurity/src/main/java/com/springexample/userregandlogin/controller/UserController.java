package com.springexample.userregandlogin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springexample.userregandlogin.model.User;
import com.springexample.userregandlogin.service.UserServiceImpl;

@RestController
@RequestMapping("/home")
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;

	
	@GetMapping("/users")
	public List<User> allusers() {
//		UserDTO user = new UserDTO("soujanya", "soumyaa m", "soumma@ss", "soujanya", true);
//		userService.saveUser(user);
		return userService.getAllUsers();
	}

	@GetMapping("/users/{id}")
	@ResponseBody
	public User user(@PathVariable Long id) {
		return userService.getUserById(id);
	}	
	
	
//	@GetMapping
//	public String homepage() {
//		return "index";
//	}
//
//	@GetMapping("/register")
//	public String showRegisterPage(Model model) {
//		model.addAttribute("user",new User());
//		return "register";
//	}
//	
//	@PostMapping("/register/save")
//	public String saveUser(@Valid @ModelAttribute("user") UserDTO user,
//			BindingResult result,Model model) {
// 		if(result.hasErrors()) {
//			return "register";
//		}
//		userService.saveUser(user);
//		return "redirect:/home/register?success";
//	}
	
}
