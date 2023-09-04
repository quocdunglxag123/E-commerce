package com.ecommerce.storesystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.storesystem.dto.DataResponse;
import com.ecommerce.storesystem.dto.StatusDto;
import com.ecommerce.storesystem.service.StatusService;

@RestController
public class StatusController {
	@Autowired
	private StatusService statusService;
	
	@PostMapping("/status")
	public DataResponse accountLogin(@RequestBody StatusDto statusDto) {
		
		if(statusDto .getServiceCall().equals("getById")) {
			return new DataResponse(statusService.getStatus(statusDto.getId()));
		}else if(statusDto.getServiceCall().equals("getAll")) {
			return new DataResponse(statusService.getAllStatus());
		}else if(statusDto.getServiceCall().equals("add")){
			return new DataResponse(statusService.addStatus(statusDto));
		}else if(statusDto.getServiceCall().equals("update")){
			return new DataResponse(statusService.updateStatus(statusDto));
		}else if(statusDto.getServiceCall().equals("delete")){
			return new DataResponse(statusService.deleteStatus(statusDto.getId()));
		}
		return new DataResponse("500", "Method Not Found");
	}
	
}
