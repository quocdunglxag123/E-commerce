package com.ecommerce.storesystem.mapstruct;

import java.util.List;
import org.mapstruct.Mapper;
import com.ecommerce.storesystem.dto.StatusDto;
import com.ecommerce.storesystem.entity.StatusEntity;

@Mapper(componentModel = "spring")
public interface StatusMapper {
	// ----------------------------Entity To DTO---------------------------
	// Status Entity
	StatusDto statusEntityToStatusDto (StatusEntity statusEntity);
	
	List<StatusDto> ListStatusEntityToListStatusDto(List<StatusEntity> list);
	// ---------------------------DTO To Entity----------------------
	// Status Dto
	StatusEntity statusDtoToStatusEntity(StatusDto statusDto);
	
	List<StatusEntity> listStatusDtoToListStatusEntity(List<StatusDto> list);
}