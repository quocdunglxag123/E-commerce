package com.ecommerce.storesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.storesystem.dto.AccountDto;
import com.ecommerce.storesystem.entity.AccountEntity;
import com.ecommerce.storesystem.exception.AccountException;
import com.ecommerce.storesystem.respository.AccountRepository;
import com.ecommerce.storesystem.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	/**
	 * Check username and password to login
	 * @param AccountDto account info
	 * @return boolean true
	 */
	public Object checkAccount(AccountDto accountDto) {
		AccountEntity accountEntity = accountRepository.findByUserName(accountDto.getUserName());
		//Check username in api is in database
		if(accountEntity != null) {
			//Check username and password in api is mapping equal with record in database
			if (accountEntity.getPassword().equals(accountDto.getPassword())
					&& accountEntity.getUserName().equals(accountDto.getUserName())) {
				return true;
			}
		}
		throw new AccountException(accountDto.getUserName());
	}
	
	//Insert new account to table account
	public Object registerAccount(AccountDto accountRegisterDto) {
		AccountEntity accountEntity = accountRepository.findByUserName(accountRegisterDto.getUserName());
		AccountEntity newAccount = new AccountEntity();
		if(accountEntity != null) {
			return false;
		}
		newAccount.setUserName(accountRegisterDto.getUserName());
		newAccount.setPassword(accountRegisterDto.getPassword());
		newAccount.setFullName(accountRegisterDto.getFullName());
		newAccount.setBirthday(accountRegisterDto.getBirthday());

		accountRepository.save(newAccount);
		return true;
	}
	
	
}
