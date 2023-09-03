package com.ecommerce.storesystem.service;

import org.springframework.stereotype.Service;

import com.ecommerce.storesystem.dto.AccountDto;

@Service
public interface AccountService {
	Object checkAccount(AccountDto accountDto);
	Object registerAccount(AccountDto accountDto);
	Object updateAccount(AccountDto accountDto);
	Object deleteAccount(Long id);

}
