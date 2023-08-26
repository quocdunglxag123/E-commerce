package com.ecommerce.storesystem.service;

import com.ecommerce.storesystem.dto.AccountDto;
import com.ecommerce.storesystem.dto.AccountRegisterDto;

public interface AccountService {
	Object checkAccount(AccountDto accountDto);
	Object registerAccount(AccountRegisterDto accountRegisterDto);
}
