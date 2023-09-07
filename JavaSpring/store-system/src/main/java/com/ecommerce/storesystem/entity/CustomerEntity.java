package com.ecommerce.storesystem.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ecommerce.storesystem.dto.CustomerDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity{
	
	@Column
	private String fullName;
	@Column
	private String phone;
	@Column
	private String address;
	@Column
	private Date birthday;
	@Column
	private Long accountId;
	
	public CustomerEntity() {
		super();
	}

	public CustomerEntity(String fullName, String phone, String address, Date birthday, Long accountId) {
		super();
		this.fullName = fullName;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		this.accountId = accountId;
	}
	
	public void setCustomerEntity(CustomerDto customerDto) {
		this.fullName = customerDto.getFullName();
		this.phone = customerDto.getPhone();
		this.address = customerDto.getAddress();
		this.birthday = customerDto.getBirthday();
		this.accountId = customerDto.getAccountId();
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd"); 
		try {
			Date startDate = df.parse(birthday);
			this.birthday = startDate;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
}
