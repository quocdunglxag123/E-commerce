package com.ecommerce.storesystem.dto;

import java.util.Date;

public class AccountNoPasswordDto  extends BaseDto{
	private String userName;
	
	private String fullName;
	
	private String phone;
	
	private Date birthday;
	

	public AccountNoPasswordDto() {
		super();
	}

	public AccountNoPasswordDto(String userName, String fullName, String phone, Date birthday) {
		super();
		this.userName = userName;
		this.fullName = fullName;
		this.phone = phone;
		this.birthday = birthday;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
