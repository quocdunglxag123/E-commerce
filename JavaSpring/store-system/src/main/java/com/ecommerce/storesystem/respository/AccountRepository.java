package com.ecommerce.storesystem.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.storesystem.entity.AccountEntity;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long>{
	AccountEntity findByUserName(String userName);
}
