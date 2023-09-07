package com.ecommerce.storesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.storesystem.dto.CustomerDto;
import com.ecommerce.storesystem.dto.DataResponse;
import com.ecommerce.storesystem.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public DataResponse accountLogin(@RequestBody CustomerDto customerDto) {
		
		if(customerDto.getServiceCall().equals("getById")) {
			return new DataResponse(customerService.getCustomer(customerDto.getId()));
		}else if(customerDto.getServiceCall().equals("getAll")) {
			return new DataResponse(customerService.getAllCustomer());
		}else if(customerDto.getServiceCall().equals("update")){
			return new DataResponse(customerService.updateCustomer(customerDto));
		}else if(customerDto.getServiceCall().equals("delete")){
			return new DataResponse(customerService.deleteCustomer(customerDto.getId()));
		}
		return new DataResponse("500", "Method Not Found");
	}
	
}
