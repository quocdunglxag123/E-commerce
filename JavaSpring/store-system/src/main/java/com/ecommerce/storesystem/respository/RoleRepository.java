package com.ecommerce.storesystem.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.storesystem.entity.RoleEntity;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	RoleEntity findOneById(Long id);	
	RoleEntity findByRoleName(String roleName);
}
