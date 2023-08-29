package com.ecommerce.storesystem.dto;

import java.util.Date;

public abstract class BaseDto {
	
	private Long id;
	
	private String updateDate;

	private Date createDate;
	
	private String serviceCall;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}


	public String getServiceCall() {
		return serviceCall;
	}
	
	public void setServiceCall(String serviceCall) {
		this.serviceCall = serviceCall;
	}
	
	public String getUpdateDate() {
		return updateDate;
	}
	
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
}
