package com.github.berndklb.springexample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.berndklb.springexample.entity.Employee;
import com.github.berndklb.springexample.entity.Example;
import com.github.berndklb.springexample.entity.TestRest;


@Service
public class CollectorService {

	DatabaseService dbService;
	RestClientService restClientService;
	
	public CollectorService(DatabaseService dbService,
			RestClientService restClientService) {
		this.dbService = dbService;
		this.restClientService = restClientService;
	}
	
	public Example getExample() {
		List<Employee> findAllEmployees = dbService.findAllEmployees();

		findAllEmployees = dbService.findAllEmployees();
		
		TestRest testRest = restClientService.test("3");
		
		Example example = new Example();
		example.setEmployee(findAllEmployees.stream().findAny().orElse(null));
		example.setTestRest(testRest);
		return example;
	}
}
