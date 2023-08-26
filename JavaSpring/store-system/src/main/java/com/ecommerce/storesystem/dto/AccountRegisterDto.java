package com.ecommerce.storesystem.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountRegisterDto {
	
	@JsonProperty("username")
	private String userName;

	@JsonProperty("password")
    private String password;
	
	@JsonProperty("fullname")
	private String fullName;
	
	@JsonProperty("phone")
	private String phone;
	
	@JsonProperty("birthday")
	private Date birthday;
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}


