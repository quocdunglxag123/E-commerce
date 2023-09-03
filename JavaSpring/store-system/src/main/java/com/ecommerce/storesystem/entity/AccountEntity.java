package com.ecommerce.storesystem.entity;


import com.ecommerce.storesystem.dto.AccountDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class AccountEntity extends BaseEntity {

	@Column
	private String userName;
	@Column
	private String password;
	@Column
	private Long roleId;

	public AccountEntity() {
		super();
	}

	public AccountEntity(String userName, String password, Long roleId) {
		super();
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
	}
	
	public void setAccountEntity(AccountDto accountDto) {
		this.userName = accountDto.getUserName();
		this.password = accountDto.getPassword();
		this.roleId = accountDto.getRoleId();
	}

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

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	
}
