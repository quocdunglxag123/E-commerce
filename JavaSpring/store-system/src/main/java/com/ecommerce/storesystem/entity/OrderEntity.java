package com.ecommerce.storesystem.entity;

import java.util.Date;

import com.ecommerce.storesystem.dto.OrderDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {
	private boolean paid;
	
	private String phone;
	
	private String address;
	
	private String fullName;
	
	
	private String productIds;
	
	private Long accountId;
	
	private Long statusId;
	
	private Date startDelivery;
	
	private Date endDelivery;
	
	public OrderEntity() {
		super();
	}

	public OrderEntity(boolean paid, String phone, String address, String fullName, String productIds, Long accountId,
			Long statusId, Date startDelivery, Date endDelivery) {
		super();
		this.paid = paid;
		this.phone = phone;
		this.address = address;
		this.fullName = fullName;
		this.productIds = productIds;
		this.accountId = accountId;
		this.statusId = statusId;
		this.startDelivery = startDelivery;
		this.endDelivery = endDelivery;
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

	public String getProductIds() {
		return productIds;
	}

	public void setProductIds(String productIds) {
		this.productIds = productIds;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getStatusId() {
		return statusId;
	}

	public void setStatusId(Long statusId) {
		this.statusId = statusId;
	}

	public Date getStartDelivery() {
		return startDelivery;
	}

	public void setStartDelivery(Date startDelivery) {
		this.startDelivery = startDelivery;
	}

	public Date getEndDelivery() {
		return endDelivery;
	}

	public void setEndDelivery(Date endDelivery) {
		this.endDelivery = endDelivery;
	}
	
	public void setOrderEntity(OrderDto orderDto) {
		this.paid = orderDto.isPaid();
		this.phone = orderDto.getPhone();
		this.address = orderDto.getAddress();
		this.fullName = orderDto.getFullName();
		this.productIds = orderDto.getProductIds();
		this.accountId = orderDto.getAccountId();
		this.statusId = orderDto.getStatusId();
		this.startDelivery = orderDto.getStartDelivery();
		this.endDelivery = orderDto.getEndDelivery();
	}

}
