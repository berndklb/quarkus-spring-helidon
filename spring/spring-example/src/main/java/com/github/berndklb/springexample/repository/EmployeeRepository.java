package com.github.berndklb.springexample.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.berndklb.springexample.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
