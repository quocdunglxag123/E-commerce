package com.ecommerce.storesystem.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.storesystem.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long>{
	AccountEntity findByUserName(String userName);
}
