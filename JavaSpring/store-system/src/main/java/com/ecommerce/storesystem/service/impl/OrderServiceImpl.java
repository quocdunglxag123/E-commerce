package com.ecommerce.storesystem.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.ecommerce.storesystem.dto.OrderDetailDto;
import com.ecommerce.storesystem.dto.OrderDto;
import com.ecommerce.storesystem.dto.ProductDto;
import com.ecommerce.storesystem.entity.OrderEntity;
import com.ecommerce.storesystem.entity.ProductEntity;
import com.ecommerce.storesystem.entity.StatusEntity;
import com.ecommerce.storesystem.exception.OrderException;
import com.ecommerce.storesystem.exception.ProductException;
import com.ecommerce.storesystem.mapstruct.OrderMapper;
import com.ecommerce.storesystem.mapstruct.ProductMapper;
import com.ecommerce.storesystem.respository.OrderRepository;
import com.ecommerce.storesystem.respository.ProductRepository;
import com.ecommerce.storesystem.respository.StatusRepository;
import com.ecommerce.storesystem.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private Environment define;

	@Autowired
	public OrderServiceImpl(OrderMapper orderMapper, OrderRepository orderRepository, ProductMapper productMapper) {
		this.orderMapper = orderMapper;
		this.productMapper = productMapper;
		this.orderRepository = orderRepository;
	}

	@Override
	public Object getAllOrder() {
		List<OrderEntity> listOrderEntity = orderRepository.findAll();
		List<OrderDetailDto> listOrderDetailDto = new ArrayList<OrderDetailDto>();
		for (OrderEntity orderEntity : listOrderEntity) {
			OrderDetailDto orderDetailDto = new OrderDetailDto();
			orderDetailDto.setAccountId(orderEntity.getAccountId());
			orderDetailDto.setAddress(orderEntity.getAddress());
			orderDetailDto.setCreateDate(orderEntity.getCreateDate());
			orderDetailDto.setEndDelivery(orderEntity.getEndDelivery());
			orderDetailDto.setFullName(orderEntity.getFullName());
			orderDetailDto.setId(orderEntity.getId());
			orderDetailDto.setPaid(orderEntity.isPaid());
			orderDetailDto.setPhone(orderEntity.getPhone());
			orderDetailDto.setServiceCall("");
			orderDetailDto.setStartDelivery(orderEntity.getStartDelivery());
			orderDetailDto.setStatusId(orderEntity.getStatusId());
			orderDetailDto.setUpdateDate(orderEntity.getUpdateDate());
			String productIdsNoWhiteSpace = orderEntity.getProductIds().replaceAll("\\s", "");
			String[] productIds = productIdsNoWhiteSpace.split(",");

			List<ProductDto> listproductDtos = new ArrayList<ProductDto>();

			for (String productId : productIds) {
				ProductEntity productEntity = productRepository.findOneById(Long.parseLong(productId));
				if (productEntity == null) {
					throw new ProductException("Product Id: " + productId + " Not Found!");
				}
				ProductDto productDto = productMapper.productEntityToProductDto(productEntity);
				listproductDtos.add(productDto);

			}
			orderDetailDto.setProduct(listproductDtos);
			listOrderDetailDto.add(orderDetailDto);
		}
		return listOrderDetailDto;
	}

	@Override
	public Object getOrder(Long id) {

		OrderEntity orderEntity = orderRepository.findOneById(id);
		OrderDetailDto orderDetailDto = new OrderDetailDto();
		orderDetailDto.setAccountId(orderEntity.getAccountId());
		orderDetailDto.setAddress(orderEntity.getAddress());
		orderDetailDto.setCreateDate(orderEntity.getCreateDate());
		orderDetailDto.setEndDelivery(orderEntity.getEndDelivery());
		orderDetailDto.setFullName(orderEntity.getFullName());
		orderDetailDto.setId(orderEntity.getId());
		orderDetailDto.setPaid(orderEntity.isPaid());
		orderDetailDto.setPhone(orderEntity.getPhone());
		orderDetailDto.setServiceCall("");
		orderDetailDto.setStartDelivery(orderEntity.getStartDelivery());
		orderDetailDto.setStatusId(orderEntity.getStatusId());
		orderDetailDto.setUpdateDate(orderEntity.getUpdateDate());
		String productIdsNoWhiteSpace = orderEntity.getProductIds().replaceAll("\\s", "");
		String[] productIds = productIdsNoWhiteSpace.split(",");

		List<ProductDto> listproductDtos = new ArrayList<ProductDto>();

		for (String productId : productIds) {
			ProductEntity productEntity = productRepository.findOneById(Long.parseLong(productId));
			if (productEntity == null) {
				throw new ProductException("Product Id: " + productId + " Not Found!");
			}
			ProductDto productDto = productMapper.productEntityToProductDto(productEntity);
			listproductDtos.add(productDto);

		}
		orderDetailDto.setProduct(listproductDtos);
		return orderDetailDto;
	}

	@Override
	public Object addOrder(OrderDto orderDto) {
		// Get statusEntity
		StatusEntity statusEntity = statusRepository.findByStatusName(define.getProperty("statusNameShoppingCart"));

		// Check duplicate Shopping Cart (one account- one shopping cart)
		Long countOrderIsNotShipping = orderRepository.findByStatusIdAndAccountId(statusEntity.getId(),
				orderDto.getAccountId());
		if (countOrderIsNotShipping != 0) {
			throw new OrderException("Account Id: " + orderDto.getAccountId()
					+ " Cannot Have More Than Two Order (Shopping Cart) With Status Id: 1");
		}

		// add order for shopping cart
		OrderEntity orderEntity = orderMapper.orderDtoToOrderEntity(orderDto);
		orderEntity.setStatusId(statusEntity.getId());
		orderRepository.save(orderEntity);
		return true;

	}

	@Override
	public Object updateOrder(OrderDto orderDto) {
		// Not permit update order is already to shipping
		if (orderDto.getStatusId() != 1) {
			throw new OrderException(
					"Order id: " + orderDto.getId() + " is Shipping With statusId: " + orderDto.getStatusId());
		}

		// Update order
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
