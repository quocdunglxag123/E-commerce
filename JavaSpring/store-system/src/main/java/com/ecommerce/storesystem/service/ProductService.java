package com.ecommerce.storesystem.service;

import com.ecommerce.storesystem.dto.ProductDto;

public interface ProductService {
	Object getAllProducts();
	Object getProduct(Long id);
	Object addProduct(ProductDto productDto);
	Object updateProduct(ProductDto productDto);
	Object deleteProduct(Long id);
}
