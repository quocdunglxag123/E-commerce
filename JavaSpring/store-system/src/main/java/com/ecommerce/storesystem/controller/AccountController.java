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

	@PostMapping("/account")
	public DataResponse accountLogin(@RequestBody AccountDto accountDto) {
		if (accountDto.getServiceCall().equals("login")) {
			return new DataResponse(accountService.checkAccount(accountDto));
		}else if(accountDto.getServiceCall().equals("register")) {
			return new DataResponse(accountService.registerAccount(accountDto));
		}else if(accountDto.getServiceCall().equals("edit")) {
			return new DataResponse(accountService.updateAccount(accountDto));
		}else if(accountDto.getServiceCall().equals("delete")) {
			return new DataResponse(accountService.deleteAccount(accountDto.getId()));
		}
		return new DataResponse("500", "Method Not Found");

	}

}
