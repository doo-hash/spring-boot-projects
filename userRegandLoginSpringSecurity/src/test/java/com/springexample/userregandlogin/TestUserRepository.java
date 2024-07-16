package com.springexample.userregandlogin;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springexample.userregandlogin.model.User;
import com.springexample.userregandlogin.repository.UserRepository;

@DataJpaTest
class TestUserRepository {

	@Autowired
	private UserRepository userrepo;

//	@Test
//	void testRepo() {
//		assertNotNull(userrepo, "userrepo is not null");
//	}

	@Test
	void testSaveUser() {
		User user = new User("qwert", "fullname", "null@null", "qwert", true);
		User createduser = userrepo.save(user);		
		Assertions.assertThat(createduser).isEqualTo(user);	
	}
	
	@Test
	void testFindUser_givenUserid() {
		User user = new User("qwert", "fullname", "null@null", "qwert", true);
		userrepo.save(user);
		User finduser = userrepo.findByUserid("qwert");
		Assertions.assertThat(finduser.getUserid()).isEqualTo("qwert");
	}
}
