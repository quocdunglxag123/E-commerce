package com.ecommerce.storesystem.dto;

import java.util.Date;

public abstract class BaseDto {
	
	private Long id;
	
	private Date updateDate;

	private Date createDate;
	
	private String serviceCall;
	
	
	public BaseDto() {
		super();		
	}


	public BaseDto(Long id, Date updateDate, Date createDate, String serviceCall) {
		super();
		this.id = id;
		this.updateDate = updateDate;
		this.createDate = createDate;
		this.serviceCall = serviceCall;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Date getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getServiceCall() {
		return serviceCall;
	}


	public void setServiceCall(String serviceCall) {
		this.serviceCall = serviceCall;
	}
	
	
	
	
	
}
