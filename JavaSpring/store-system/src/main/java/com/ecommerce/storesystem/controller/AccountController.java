package com.ecommerce.storesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.storesystem.dto.AccountDto;
import com.ecommerce.storesystem.dto.DataResponse;
import com.ecommerce.storesystem.service.AccountService;

@RestController
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	@PostMapping("/login")
	public DataResponse accountLogin(@RequestBody AccountDto accountDto) {
		return new DataResponse(accountService.checkAccount(accountDto));
	}
}
