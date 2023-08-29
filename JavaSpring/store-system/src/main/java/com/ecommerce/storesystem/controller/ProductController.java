package com.ecommerce.storesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.storesystem.dto.DataResponse;
import com.ecommerce.storesystem.dto.ProductDto;
import com.ecommerce.storesystem.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@PostMapping("/product")
	public DataResponse accountLogin(@RequestBody ProductDto productDto) {
		
		if(productDto.getServiceCall().equals("SearchProduct")) {
			return new DataResponse(productService.getProduct(productDto.getId()));
		}else {
			return new DataResponse(productService.getAllProducts());
		}
	}
	
}
