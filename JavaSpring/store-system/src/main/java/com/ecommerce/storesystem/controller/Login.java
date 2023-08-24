package com.ecommerce.storesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.storesystem.dto.AccountDto;
import com.ecommerce.storesystem.service.AccountService;

@RestController
public class Login {
	@Autowired
	private AccountService accountService;
	@PostMapping("/login")
	public Boolean accountLogin(@RequestBody AccountDto accountDto) {
		return accountService.checkAccount(accountDto);
	}
}
