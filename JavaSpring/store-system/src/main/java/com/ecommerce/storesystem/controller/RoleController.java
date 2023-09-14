package com.ecommerce.storesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.storesystem.dto.DataResponse;
import com.ecommerce.storesystem.dto.RoleDto;
import com.ecommerce.storesystem.service.RoleService;

@RestController
@CrossOrigin
public class RoleController {
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/role")
	public DataResponse accountLogin(@RequestBody RoleDto roleDto) {
		
		if(roleDto .getServiceCall().equals("getById")) {
			return new DataResponse(roleService.getRole(roleDto.getId()));
		}else if(roleDto.getServiceCall().equals("getAll")) {
			return new DataResponse(roleService.getAllRole());
		}else if(roleDto.getServiceCall().equals("add")){
			return new DataResponse(roleService.addRole(roleDto));
		}else if(roleDto.getServiceCall().equals("update")){
			return new DataResponse(roleService.updateRole(roleDto));
		}else if(roleDto.getServiceCall().equals("delete")){
			return new DataResponse(roleService.deleteRole(roleDto.getId()));
		}
		return new DataResponse("500", "Method Not Found");
	}
	
}
