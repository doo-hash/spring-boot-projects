package com.springexample.userregandlogin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.springexample.userregandlogin.controller.UserController;
import com.springexample.userregandlogin.model.UserDTO;
import com.springexample.userregandlogin.service.UserServiceImpl;

@WebMvcTest(UserController.class)
class TestUserController {

	@MockBean
	private UserServiceImpl userservice;
	
	@Autowired
	private MockMvc mockmvc;
	
	@Test
	void testUser() throws Exception{
		UserDTO user = new UserDTO("sahil","sahil khan","sahil@ss","sahil",true);
		userservice.saveUser(user);
		mockmvc.perform(MockMvcRequestBuilders.get("/home/users/37")
		.contentType(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
}
