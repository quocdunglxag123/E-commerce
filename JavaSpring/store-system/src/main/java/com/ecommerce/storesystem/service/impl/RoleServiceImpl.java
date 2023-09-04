package com.ecommerce.storesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.storesystem.dto.RoleDto;
import com.ecommerce.storesystem.entity.RoleEntity;
import com.ecommerce.storesystem.mapstruct.RoleMapper;
import com.ecommerce.storesystem.respository.RoleRepository;
import com.ecommerce.storesystem.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	public RoleServiceImpl(RoleMapper roleMapper, RoleRepository roleRepository) {
		this.roleMapper = roleMapper;
		this.roleRepository = roleRepository;
	}
	
	@Override
	public Object getAllRole() {
		return roleMapper.ListRoleEntityToListRoleDto(roleRepository.findAll());
	}

	@Override
	public Object getRole(Long id) {
		return roleMapper.roleEntityToRoleDto(roleRepository.findOneById(id));
	}

	@Override
	public Object addRole(RoleDto roleDto) {
		RoleEntity roleEntity = roleMapper.roleDtoToRoleEntity(roleDto);		
		roleRepository.save(roleEntity);
		return true;
	}
	
	@Override
	public Object updateRole(RoleDto roleDto) {
		RoleEntity roleEntityUpdate = roleRepository.findOneById(roleDto.getId());
		if (roleEntityUpdate != null) {
			roleEntityUpdate.setRoleEntity(roleDto);
			roleRepository.save(roleEntityUpdate);
			return true;
		}
		return false;
	}

	@Override
	public Object deleteRole(Long id) {
		roleRepository.deleteById(id);
		return true;
	}
	
}
