package com.ecommerce.storesystem.service;

import org.springframework.stereotype.Service;

import com.ecommerce.storesystem.dto.OrderDto;
@Service
public interface OrderService {
	Object getAllOrder();
	Object getOrder(Long id);
	Object addOrder(OrderDto orderDto);
	Object updateOrder(OrderDto orderDto);
	Object deleteOrder(Long id);
}
