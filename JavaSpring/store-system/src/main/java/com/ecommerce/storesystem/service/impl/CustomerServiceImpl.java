package com.ecommerce.storesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.storesystem.dto.CustomerDto;
import com.ecommerce.storesystem.entity.CustomerEntity;
import com.ecommerce.storesystem.mapstruct.CustomerMapper;
import com.ecommerce.storesystem.respository.CustomerRepository;
import com.ecommerce.storesystem.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CustomerMapper customerMapper;

	@Autowired
	public CustomerServiceImpl(CustomerMapper customerMapper, CustomerRepository customerRepository) {
		this.customerMapper = customerMapper;
		this.customerRepository = customerRepository;
	}

	@Override
	public Object getAllCustomer() {
		return customerMapper.ListCustomerEntityToListCustomerDto(customerRepository.findAll());
	}

	@Override
	public Object getCustomer(Long id) {
		return customerMapper.customerEntityToCustomerDto(customerRepository.findOneById(id));
	}

	@Override
	public Object addCustomer(CustomerDto customerDto) {
		CustomerEntity customerEntity = customerMapper.customerDtoToCustomerEntity(customerDto);
		customerRepository.save(customerEntity);
		return true;
	}

	@Override
	public Object updateCustomer(CustomerDto customerDto) {
		CustomerEntity customerEntityUpdate = customerRepository.findOneById(customerDto.getId());
		if (customerEntityUpdate != null) {
			customerEntityUpdate.setCustomerEntity(customerDto);
			customerRepository.save(customerEntityUpdate);
			return true;
		}
		return false;
	}

	@Override
	public Object deleteCustomer(Long id) {
		customerRepository.deleteById(id);
		return true;
	}

}
