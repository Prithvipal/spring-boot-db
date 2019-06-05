package com.spring.practice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.dao.ICompServiceDao;

import com.spring.practice.dto.ServiceDto;
import com.spring.practice.entity.CompService;
import com.spring.practice.service.IService;

@Service
public class SeriveImpl implements IService {

	
	@Autowired
	private ICompServiceDao compServiceDao; 
	
	@Override
	public List<ServiceDto> getServices() {
		Iterable<CompService> compServices = compServiceDao.findAll();
		List<ServiceDto> serviceDtos = new ArrayList<>();
		for (CompService compService : compServices) {
			ServiceDto serviceDto = new ServiceDto();
			serviceDto.setId(compService.getId());
			serviceDto.setName(compService.getName());
			serviceDtos.add(serviceDto);
		}
		return serviceDtos;
	}

	@Override
	public void saveService(ServiceDto serviceDto) {
		CompService compService = new CompService();
		compService.setName(serviceDto.getName());
		compServiceDao.save(compService);
	}

	@Override
	public ServiceDto getServiceById(Long id) {
		Optional<CompService> compServiceOp = compServiceDao.findById(id);
		CompService compService = compServiceOp.get();
		ServiceDto serviceDto = new ServiceDto();
		serviceDto.setId(compService.getId());
		serviceDto.setName(compService.getName());
		return serviceDto;
	}

	@Override
	public void deleteServiceById(Long id) {
		compServiceDao.deleteById(id);
	}

	@Override
	public void updateServiceById(Long id, ServiceDto serviceDto) {
		Optional<CompService> compServiceOp = compServiceDao.findById(id);
		CompService compService = compServiceOp.get();//.setName(serviceDto.getName());
		compService.setName(serviceDto.getName());
		compServiceDao.save(compService);
		
	}
	
	

}
