package com.ecommerce.storesystem.entity;

import com.ecommerce.storesystem.dto.RoleDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {
	@Column
	private String roleName;
	
	public RoleEntity() {
		super();
	}
	
	public RoleEntity(String roleName) {
		super();
		this.roleName = roleName;
	}
	public void setRoleEntity(RoleDto roleDto) {
		this.roleName = roleDto.getRoleName();
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	
	
	
}
