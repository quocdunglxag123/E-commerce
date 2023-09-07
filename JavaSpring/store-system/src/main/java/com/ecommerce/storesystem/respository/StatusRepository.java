package com.ecommerce.storesystem.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ecommerce.storesystem.entity.StatusEntity;

@Repository
public interface StatusRepository extends JpaRepository<StatusEntity, Long>{
	StatusEntity findOneById(Long id);	
	StatusEntity findByStatusName(String statusName);	
}
