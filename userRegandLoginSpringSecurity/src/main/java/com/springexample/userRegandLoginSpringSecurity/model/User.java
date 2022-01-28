package com.springexample.userRegandLoginSpringSecurity.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name= "users", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class User{
	
	@Id
	@GeneratedValue
	private Long id;
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
	
	@ManyToMany(fetch =FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_roles",
			joinColumns =  @JoinColumn(
					name = "user_uid", referencedColumnName = "id"),
			inverseJoinColumns =  @JoinColumn(
					name = "role_uid", referencedColumnName = "id")
			)
	private Collection<Roles> roles;
	
	@Column(name= "check_terms")
	private boolean checkterms;

	
	
	@Override
	public String toString() {
		return "User [userid=" + userid + ", fullname=" + fullname + ", email=" + email + ", password=" + password
				+ ", roles=" + roles + ", checkterms=" + checkterms + "]";
	}
	public User() {
		super();
	}
	
	
	public User(@NotEmpty(message = "user id must not be empty") String userid,
			@NotEmpty(message = "full name must not be empty") String fullname,
			@NotEmpty(message = "email must not be empty") @Email(message = "invalid email") String email,
			@NotEmpty(message = "password must not be empty") String password, Collection<Roles> roles,
			boolean checkterms) {
		super();
		this.userid = userid;
		this.fullname = fullname;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.checkterms = checkterms;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Collection<Roles> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}
	public boolean isCheckterms() {
		return checkterms;
	}
	public void setCheckterms(boolean checkterms) {
		this.checkterms = checkterms;
	}
		
}
