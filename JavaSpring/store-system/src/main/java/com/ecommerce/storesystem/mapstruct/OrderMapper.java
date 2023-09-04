package com.ecommerce.storesystem.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import com.ecommerce.storesystem.dto.OrderDto;
import com.ecommerce.storesystem.entity.OrderEntity;

@Mapper(componentModel = "spring")
public interface OrderMapper {
	// ----------------------------Entity To DTO---------------------------
	// order entity
	OrderDto orderEntityToOrderDto (OrderEntity orderEntity);
	
	List<OrderDto> ListOrderEntityToListOrderDto(List<OrderEntity> list);
	// ---------------------------DTO To Entity----------------------
	// order dto
	OrderEntity orderDtoToOrderEntity(OrderDto orderDto);
	
	List<OrderEntity> listorderDtoToListOrderEntity(List<OrderDto> list);
}