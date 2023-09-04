package com.ecommerce.storesystem.dto;

public class StatusDto extends BaseDto{
	private String statusName;

	public StatusDto() {
		super();
	}

	public StatusDto(String statusName) {
		super();
		this.statusName = statusName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

}
