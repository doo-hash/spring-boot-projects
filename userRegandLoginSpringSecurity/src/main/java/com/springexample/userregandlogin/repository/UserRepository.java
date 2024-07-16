package com.springexample.userregandlogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springexample.userregandlogin.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	User findByUserid(String userid);
	
	User findByEmail(String email);
	User findByFullname(String fullname);
	boolean existsByUserid(String userid);
	boolean existsByEmail(String email);
	boolean existsByFullname(String fullname);
}

