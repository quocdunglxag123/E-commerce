package com.ecommerce.storesystem.service;

import org.springframework.stereotype.Service;

import com.ecommerce.storesystem.dto.CustomerDto;
@Service
public interface CustomerService {
	Object getAllCustomer();
	Object getCustomer(Long id);
	Object addCustomer(CustomerDto customerDto);
	Object updateCustomer(CustomerDto customerDto);
	Object deleteCustomer(Long id);
}
