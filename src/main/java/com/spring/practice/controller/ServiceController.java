package com.spring.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.practice.dto.ServiceDto;
import com.spring.practice.service.IService;

@RestController
public class ServiceController {

	@Autowired
	private IService service;
	
	@GetMapping("/services")
	public List<ServiceDto> getServices(){
		return service.getServices();
	}
	
	@PostMapping("/services")
	public void saveService(@RequestBody ServiceDto serviceDto) {
		service.saveService(serviceDto);
	}
	
	@GetMapping("/services/{id}")
	public ServiceDto getServiceById(@PathVariable("id") Long id){
		return service.getServiceById(id);
	}
	
	@DeleteMapping("/services/{id}")
	public void deleteServiceById(@PathVariable("id") Long id){
		service.deleteServiceById(id);
	}
	
	@PutMapping("/services/{id}")
	public void updateServiceById(@PathVariable("id") Long id, @RequestBody ServiceDto serviceDto){
		service.updateServiceById(id, serviceDto);
	}
}
