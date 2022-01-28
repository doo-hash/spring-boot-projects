package com.springexample.userRegandLoginSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springexample.userRegandLoginSpringSecurity.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	User findByUserid(String userid);
}

