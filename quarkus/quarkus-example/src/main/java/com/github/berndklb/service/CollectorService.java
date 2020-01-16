package com.github.berndklb.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.github.berndklb.entity.Employee;
import com.github.berndklb.entity.Example;
import com.github.berndklb.entity.TestRest;

@ApplicationScoped
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
		if(findAllEmployees.isEmpty()) {
			dbService.createDummyEmployees();
		}
		findAllEmployees = dbService.findAllEmployees();
		
		TestRest testRest = restClientService.test("3");
		
		Example example = new Example();
		example.setEmployee(findAllEmployees.stream().findAny().orElse(null));
		example.setTestRest(testRest);
		return example;
	}
}
