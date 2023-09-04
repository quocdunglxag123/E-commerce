package com.ecommerce.storesystem.mapstruct;

import java.util.List;
import org.mapstruct.Mapper;
import com.ecommerce.storesystem.dto.RoleDto;
import com.ecommerce.storesystem.entity.RoleEntity;

@Mapper(componentModel = "spring")
public interface RoleMapper {
	// ----------------------------Entity To DTO---------------------------
	// Role Entity
	RoleDto roleEntityToRoleDto (RoleEntity roleEntity);
	
	List<RoleDto> ListRoleEntityToListRoleDto(List<RoleEntity> list);
	// ---------------------------DTO To Entity----------------------
	// RoleDTO
	RoleEntity roleDtoToRoleEntity(RoleDto roletDto);
	
	List<RoleEntity> listRoleDtoToListRoleEntity(List<RoleDto> list);
}