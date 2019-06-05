package com.spring.practice.service;

import java.util.List;

import com.spring.practice.dto.ServiceDto;

public interface IService {

	List<ServiceDto> getServices();
	
	void saveService(ServiceDto serviceDto);

	ServiceDto getServiceById(Long id);

	void deleteServiceById(Long id);

	void updateServiceById(Long id, ServiceDto serviceDto);
}
