package com.ecommerce.storesystem.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import com.ecommerce.storesystem.dto.ProductDto;
import com.ecommerce.storesystem.entity.ProductEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {
	// ----------------------------Entity To DTO---------------------------
	// Product
	ProductDto productEntityToProductDto (ProductEntity productEntity);
	
	List<ProductDto> ListProductEntityToListProductDto(List<ProductEntity> list);
	// ---------------------------DTO To Entity----------------------
	// ProductDTO
	ProductEntity productDtoToProductEntity(ProductDto productDto);
	
	List<ProductEntity> listProductDtoToListProductEntity(List<ProductDto> list);
}