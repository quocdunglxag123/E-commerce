package com.ecommerce.storesystem.entity;

import com.ecommerce.storesystem.dto.StatusDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "status")
public class StatusEntity extends BaseEntity {
	@Column
	private String statusName;
	
	public StatusEntity() {
		super();
	}

	public StatusEntity(String statusName) {
		super();
		this.statusName = statusName;
	}
	
	public void setStatusEntity(StatusDto statusDto) {
		this.statusName = statusDto.getStatusName();
	}
	
	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}
