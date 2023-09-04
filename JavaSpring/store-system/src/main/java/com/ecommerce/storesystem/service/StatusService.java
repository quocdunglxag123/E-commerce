package com.ecommerce.storesystem.service;

import org.springframework.stereotype.Service;
import com.ecommerce.storesystem.dto.StatusDto;

@Service
public interface StatusService {
	Object getAllStatus();
	Object getStatus(Long id);
	Object addStatus(StatusDto statusDto);
	Object updateStatus(StatusDto statusDto);
	Object deleteStatus(Long id);
}
