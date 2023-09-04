package com.ecommerce.storesystem.service;

import org.springframework.stereotype.Service;
import com.ecommerce.storesystem.dto.RoleDto;

@Service
public interface RoleService {
	Object getAllRole();
	Object getRole(Long id);
	Object addRole(RoleDto roleDto);
	Object updateRole(RoleDto roleDto);
	Object deleteRole(Long id);
}
