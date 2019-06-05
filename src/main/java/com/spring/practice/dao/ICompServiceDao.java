package com.spring.practice.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.practice.entity.CompService;



public interface ICompServiceDao extends CrudRepository<CompService, Long> {
	
}
