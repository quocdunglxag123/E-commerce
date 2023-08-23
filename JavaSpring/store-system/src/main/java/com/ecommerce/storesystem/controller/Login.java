package com.ecommerce.storesystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.storesystem.dto.AccountDto;

@Controller
public class Login {
	@RestController
	public class NewAPI {
	        @PostMapping("/login")
	        public AccountDto createNew(@RequestBody AccountDto accountDto) {
	                return accountDto;
	        }

	}
}
