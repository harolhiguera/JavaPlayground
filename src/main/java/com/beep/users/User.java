package com.beep.users;

import javax.persistence.Entity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.beep.core.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User extends BaseEntity{
	
	public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();
	private String firstName;
	private String lastName;
	private String userName;
	@JsonIgnore
	private String password;
	@JsonIgnore
	private String[] roles;

	protected User() {
		super();
	}

	// Constructors
	
	public User(String userName, String firstName, String lastName, String password, String[] roles) {
		this();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		setPassword(password);
		this.roles = roles;
	}
	
	// Password encoding
	
	public void setPassword(String password) {
		this.password = PASSWORD_ENCODER.encode(password);
	}

	// GETTERS AND SETTERS ...
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String[] getRoles() {
		return roles;
	}


	public void setRoles(String[] roles) {
		this.roles = roles;
	}


	public String getPassword() {
		return password;
	}
	
}
