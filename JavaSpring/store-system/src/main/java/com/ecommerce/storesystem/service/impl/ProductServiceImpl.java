package com.ecommerce.storesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.storesystem.dto.ProductDto;
import com.ecommerce.storesystem.entity.ProductEntity;
import com.ecommerce.storesystem.mapstruct.ProductMapper;
import com.ecommerce.storesystem.respository.ProductRepository;
import com.ecommerce.storesystem.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	public ProductServiceImpl(ProductMapper productMapper, ProductRepository productRepo) {
		this.productMapper = productMapper;
		this.productRepo = productRepo;
	}
	
	@Override
	public Object getAllProducts() {
		return productMapper.ListProductEntityToListProductDto(productRepo.findAll());
	}

	@Override
	public Object getProduct(Long id) {
		return productMapper.productEntityToProductDto(productRepo.findOneById(id));
	}

	@Override
	public Object addProduct(ProductDto productDto) {
		ProductEntity productEntity = productMapper.productDtoToProductEntity(productDto);		
		productRepo.save(productEntity);
		return true;
	}
	
	@Override
	public Object updateProduct(ProductDto productDto) {
		ProductEntity productEntityUpdate = productRepo.findOneById(productDto.getId());
		if (productEntityUpdate != null) {
			productEntityUpdate.setProductEntity(productDto);
			productRepo.save(productEntityUpdate);
			return true;
		}
		return false;
	}

	@Override
	public Object deleteProduct(Long id) {
		productRepo.deleteById(id);
		return true;
	}
	
}
