package com.ecommerce.storesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.storesystem.dto.AccountDto;
import com.ecommerce.storesystem.dto.AccountRegisterDto;
import com.ecommerce.storesystem.dto.DataResponse;
import com.ecommerce.storesystem.entity.AccountEntity;
import com.ecommerce.storesystem.respository.AccountRepository;
import com.ecommerce.storesystem.service.AccountService;

@RestController
public class Register {
	@Autowired
    private AccountService accountService;

    @PostMapping("/register")
    public DataResponse accountRegister(@RequestBody AccountRegisterDto accountRegisterDto) {
		return new DataResponse(accountService.registerAccount(accountRegisterDto));
	}
}
