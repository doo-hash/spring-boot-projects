package com.springexample.userRegandLoginSpringSecurity.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {

	@Id
	@GeneratedValue
	private Long id;
	
	private String role;
	
	public Long getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Roles [role=" + role + "]";
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Roles() {
		super();
	}
	public Roles(String role) {
		super();
		this.role = role;
	}
	
	
}
