package com.github.berndklb.springexample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.berndklb.springexample.entity.Employee;
import com.github.berndklb.springexample.repository.EmployeeRepository;

@Service
public class DatabaseService {

	final EmployeeRepository employeeRepo;
	
	public DatabaseService(EmployeeRepository employeeRepo) {
		this.employeeRepo = employeeRepo;
	}
	
	public List<Employee> findAllEmployees(){
		List<Employee> emps = new ArrayList<>();
		employeeRepo.findAll().forEach(emps::add);
		
		return emps;
	}
	
}
