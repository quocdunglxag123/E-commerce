package com.ecommerce.storesystem.mapstruct;

import java.util.List;
import org.mapstruct.Mapper;
import com.ecommerce.storesystem.dto.CustomerDto;
import com.ecommerce.storesystem.entity.CustomerEntity;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
	// ----------------------------Entity To DTO---------------------------
	// Customer Entity
	CustomerDto customerEntityToCustomerDto (CustomerEntity customerEntity);
	
	List<CustomerDto> ListCustomerEntityToListCustomerDto(List<CustomerEntity> list);
	// ---------------------------DTO To Entity----------------------
	// Customer Dto
	CustomerEntity customerDtoToCustomerEntity(CustomerDto customerDto);
	
	List<CustomerEntity> listCustomerDtoToListCustomerEntity(List<CustomerDto> list);
}