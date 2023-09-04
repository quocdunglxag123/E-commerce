package com.ecommerce.storesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.storesystem.dto.OrderDto;
import com.ecommerce.storesystem.entity.OrderEntity;
import com.ecommerce.storesystem.exception.OrderException;
import com.ecommerce.storesystem.mapstruct.OrderMapper;
import com.ecommerce.storesystem.respository.OrderRepository;
import com.ecommerce.storesystem.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	public OrderServiceImpl(OrderMapper orderMapper, OrderRepository orderRepository) {
		this.orderMapper = orderMapper;
		this.orderRepository = orderRepository;
	}
	
	@Override
	public Object getAllOrder() {
		return orderMapper.ListOrderEntityToListOrderDto(orderRepository.findAll());
	}

	@Override
	public Object getOrder(Long id) {
		return orderMapper.orderEntityToOrderDto(orderRepository.findOneById(id));
	}

	@Override
	public Object addOrder(OrderDto orderDto) {
		Long countOrderIsNotShipping = orderRepository.findByStatusIdAndAccountId((long)1,orderDto.getAccountId());
		if(countOrderIsNotShipping != 0) {
			throw new OrderException("Account Id: "+orderDto.getAccountId()+" Cannot Have More Than Two Order With Status Id: 1");
		}
		OrderEntity orderEntity = orderMapper.orderDtoToOrderEntity(orderDto);
		orderEntity.setStatusId((long)1);
		orderRepository.save(orderEntity);
		return true;
		
	}
	
	@Override
	public Object updateOrder(OrderDto orderDto) {
		if(orderDto.getStatusId() != 1) {
			throw new OrderException("Order id: "+orderDto.getId()+" is Shipping With statusId: "+ orderDto.getStatusId());
		}
		OrderEntity orderEntityUpdate = orderRepository.findOneById(orderDto.getId());
		if (orderEntityUpdate != null) {
			orderEntityUpdate.setOrderEntity(orderDto);
			orderRepository.save(orderEntityUpdate);
			return true;
		}
		return false;
	}

	@Override
	public Object deleteOrder(Long id) {
		orderRepository.deleteById(id);
		return true;
	}
	
}
