package com.ecommerce.storesystem.dto;


public class AccountNoPasswordDto  extends BaseDto{
	private String userName;
	
	private String fullName;
	
	private String phone;
	
	private String birthday;
	

	public AccountNoPasswordDto() {
		super();
	}

	public AccountNoPasswordDto(String userName, String fullName, String phone, String birthday) {
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
