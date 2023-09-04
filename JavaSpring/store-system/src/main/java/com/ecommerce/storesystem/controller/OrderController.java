package com.ecommerce.storesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.storesystem.dto.DataResponse;
import com.ecommerce.storesystem.dto.OrderDto;
import com.ecommerce.storesystem.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/order")
	public DataResponse accountLogin(@RequestBody OrderDto orderDto) {
		
		if(orderDto.getServiceCall().equals("getById")) {
			return new DataResponse(orderService.getOrder(orderDto.getId()));
		}else if(orderDto.getServiceCall().equals("getAll")) {
			return new DataResponse(orderService.getAllOrder());
		}else if(orderDto.getServiceCall().equals("add")){
			return new DataResponse(orderService.addOrder(orderDto));
		}else if(orderDto.getServiceCall().equals("update")){
			return new DataResponse(orderService.updateOrder(orderDto));
		}else if(orderDto.getServiceCall().equals("delete")){
			return new DataResponse(orderService.deleteOrder(orderDto.getId()));
		}
		return new DataResponse("500", "Method Not Found");
	}
	
}
