package com.ecommerce.storesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.storesystem.dto.AccountDto;
import com.ecommerce.storesystem.entity.AccountEntity;
import com.ecommerce.storesystem.entity.CustomerEntity;
import com.ecommerce.storesystem.entity.OrderEntity;
import com.ecommerce.storesystem.exception.AccountException;
import com.ecommerce.storesystem.respository.AccountRepository;
import com.ecommerce.storesystem.respository.CustomerRepository;
import com.ecommerce.storesystem.respository.OrderRepository;
import com.ecommerce.storesystem.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OrderRepository orderRepository;
	
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
				return accountEntity.getId();
			}
		}
		throw new AccountException("Invalid username or password");
	}
	
	
	
	//Insert new account to table account
	public Object registerAccount(AccountDto accountDto) {
		
		AccountEntity accountEntity = accountRepository.findByUserName(accountDto.getUserName());
		if(accountEntity != null) {
			throw new AccountException(accountDto.getUserName()+ "is Duplicated!");
		}
		AccountEntity newAccount = new AccountEntity();
		newAccount.setUserName(accountDto.getUserName());
		newAccount.setPassword(accountDto.getPassword());
		newAccount.setRoleId((long)3);
		accountRepository.save(newAccount);
		CustomerEntity newCustomer = new CustomerEntity();
		newCustomer.setFullName(accountDto.getFullName());
		newCustomer.setBirthday(accountDto.getBirthday());
		newCustomer.setAddress(accountDto.getAddress());
		newCustomer.setAccountId(newAccount.getId());
		newCustomer.setPhone(accountDto.getPhone());
		customerRepository.save(newCustomer);
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setAccountId(newAccount.getId());
		orderEntity.setStatusId((long)1);
		orderEntity.setPaid(false);
		orderRepository.save(orderEntity);
		
		newAccount.setPassword("");
		return newAccount;
	}



	@Override
	public Object updateAccount(AccountDto accountDto) {
		AccountEntity accountEntity = accountRepository.findOneById(accountDto.getId());
		if (accountEntity != null) {
			//Self Account Update
			if(accountEntity.getUserName() == accountDto.getUserName()) {
				accountEntity.setAccountEntity(accountDto);
				accountRepository.save(accountEntity);
				return true;
			//Admin Update
			}else {
				if(accountEntity.getRoleId() == 1) {
					AccountEntity accountEntityUpdate = accountRepository.findByUserName(accountDto.getUserName());
					accountEntityUpdate.setAccountEntity(accountDto);
					accountRepository.save(accountEntityUpdate);
					return true;
				}else {
					throw new AccountException(accountDto.getId()+ " is Not Permit To Update Account "+accountDto.getUserName());	
				}
			}
			
		}
		return false;
	}



	@Override
	public Object deleteAccount(Long id) {
		accountRepository.deleteById(id);
		return true;
	}
	
	
}
