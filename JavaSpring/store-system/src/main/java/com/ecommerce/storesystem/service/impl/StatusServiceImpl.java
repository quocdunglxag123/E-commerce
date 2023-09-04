package com.ecommerce.storesystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.storesystem.dto.StatusDto;
import com.ecommerce.storesystem.entity.StatusEntity;
import com.ecommerce.storesystem.mapstruct.StatusMapper;
import com.ecommerce.storesystem.respository.StatusRepository;
import com.ecommerce.storesystem.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService {
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private StatusMapper statusMapper;
	
	@Autowired
	public StatusServiceImpl(StatusMapper statusMapper, StatusRepository statusRepository) {
		this.statusMapper = statusMapper;
		this.statusRepository = statusRepository;
	}
	
	@Override
	public Object getAllStatus() {
		return statusMapper.ListStatusEntityToListStatusDto(statusRepository.findAll());
	}

	@Override
	public Object getStatus(Long id) {
		return statusMapper.statusEntityToStatusDto(statusRepository.findOneById(id));
	}

	@Override
	public Object addStatus(StatusDto statusDto) {
		StatusEntity statusEntity = statusMapper.statusDtoToStatusEntity(statusDto);		
		statusRepository.save(statusEntity);
		return true;
	}
	
	@Override
	public Object updateStatus(StatusDto statusDto) {
		StatusEntity statusEntityUpdate = statusRepository.findOneById(statusDto.getId());
		if (statusEntityUpdate != null) {
			statusEntityUpdate.setStatusEntity(statusDto);
			statusRepository.save(statusEntityUpdate);
			return true;
		}
		return false;
	}

	@Override
	public Object deleteStatus(Long id) {
		statusRepository.deleteById(id);
		return true;
	}
	
}
