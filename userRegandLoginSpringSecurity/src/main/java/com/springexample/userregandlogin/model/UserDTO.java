package com.springexample.userregandlogin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class UserDTO{
	
	@NotEmpty(message="user id must not be empty")
	@Column(name="user_id",nullable = false)
	private String userid;
	@NotEmpty(message="full name must not be empty")
	@Column(name = "full_name",nullable = false)
	private String fullname;
	@NotEmpty(message="email must not be empty")
	@Email(message="invalid email")
	@Column(name= "email",nullable = false)
	private String email;
	@NotEmpty(message="password must not be empty")
	@Column(name= "password",nullable = false)
	private String password;
		
	@Column(name= "check_terms")
	private boolean checkterms;

	
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", fullname=" + fullname + ", email=" + email + ", password=" + password
				+ ", checkterms=" + checkterms + "]";
	}
	public UserDTO() {
		super();
	}
	
	
	public UserDTO(@NotEmpty(message = "user id must not be empty") String userid,
			@NotEmpty(message = "full name must not be empty") String fullname,
			@NotEmpty(message = "email must not be empty") @Email(message = "invalid email") String email,
			@NotEmpty(message = "password must not be empty") String password,
			boolean checkterms) {
		super();
		this.userid = userid;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.checkterms = checkterms;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isCheckterms() {
		return checkterms;
	}
	public void setCheckterms(boolean checkterms) {
		this.checkterms = checkterms;
	}
		
}
