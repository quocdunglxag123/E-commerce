package com.ecommerce.storesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.storesystem.dto.AccountDto;
import com.ecommerce.storesystem.entity.AccountEntity;
import com.ecommerce.storesystem.respository.AccountRepository;
import com.ecommerce.storesystem.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public boolean checkAccount(AccountDto accountDto) {
		AccountEntity accountEntity = accountRepository.findByUserName(accountDto.getUserName());
		if(accountEntity != null) {
			if (accountEntity.getPassword().equals(accountDto.getPassword())
					&& accountEntity.getUserName().equals(accountDto.getUserName())) {
				return true;
			}
		}
		return false;
	}
}