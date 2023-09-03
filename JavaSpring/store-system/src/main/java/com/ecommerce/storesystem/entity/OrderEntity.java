package com.ecommerce.storesystem.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {
	private boolean paid;
	
	private String phone;
	
	private String address;
	
	private String fullName;
	
	private Long productId;
	
	private Long accountId;
	
	public OrderEntity() {
		super();
	}

	public OrderEntity(boolean paid, String phone, String address, String fullName, Long productId, Long accountId) {
		super();
		this.paid = paid;
		this.phone = phone;
		this.address = address;
		this.fullName = fullName;
		this.productId = productId;
		this.accountId = accountId;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	
}
