package com.appsdeveloperblog.photoapp.api.users.shared;

import java.io.Serializable;

public class UserDto implements Serializable {

	// this class should implements Serializable 
	/**
	 * 
	 */
	private static final long serialVersionUID = -2887343109242116308L;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
	private String userId;
	private String encrptedPassword;  // Service layer will change the actual string password into encrypted one and save it into DB

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEncrptedPassword() {
		return encrptedPassword;
	}

	public void setEncrptedPassword(String encrptedPassword) {
		this.encrptedPassword = encrptedPassword;
	}

}
