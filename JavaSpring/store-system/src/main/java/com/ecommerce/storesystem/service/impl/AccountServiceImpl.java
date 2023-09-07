package com.ecommerce.storesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.ecommerce.storesystem.dto.AccountDto;
import com.ecommerce.storesystem.entity.AccountEntity;
import com.ecommerce.storesystem.entity.CustomerEntity;
import com.ecommerce.storesystem.entity.OrderEntity;
import com.ecommerce.storesystem.entity.RoleEntity;
import com.ecommerce.storesystem.entity.StatusEntity;
import com.ecommerce.storesystem.exception.AccountException;
import com.ecommerce.storesystem.respository.AccountRepository;
import com.ecommerce.storesystem.respository.CustomerRepository;
import com.ecommerce.storesystem.respository.OrderRepository;
import com.ecommerce.storesystem.respository.RoleRepository;
import com.ecommerce.storesystem.respository.StatusRepository;
import com.ecommerce.storesystem.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private Environment define;
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
		//Check duplicate username 
		AccountEntity accountEntity = accountRepository.findByUserName(accountDto.getUserName());
		if(accountEntity != null) {
			throw new AccountException(accountDto.getUserName()+ "is Duplicated!");
		}
		
		//Get Role Id Customer
		RoleEntity roleEntity = roleRepository.findByRoleName(define.getProperty("roleNameCustomer"));
		if(roleEntity == null) {
			throw new AccountException("Cannot Create New Account Because Role \""+define.getProperty("roleNameCustomer")+"\" Not Found");
		}
		
		//Get statusEntity
		StatusEntity statusEntity = statusRepository.findByStatusName(define.getProperty("statusNameShoppingCart"));
		if(statusEntity == null) {
			throw new AccountException("Cannot Create New Account Because Id Status Of  \""+define.getProperty("statusNameShoppingCart")+"\" Not Found");
		}		
				
		// Register Account Info To Database
		AccountEntity newAccount = new AccountEntity();
		newAccount.setUserName(accountDto.getUserName());
		newAccount.setPassword(accountDto.getPassword());
		newAccount.setRoleId(roleEntity.getId());
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
		orderEntity.setStatusId(statusEntity.getId());
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
				RoleEntity roleEntity = roleRepository.findOneById(accountEntity.getRoleId());
				if(roleEntity.getRoleName() == define.getProperty("roleNameAdmin")) {
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
