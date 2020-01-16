package com.github.berndklb.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.github.berndklb.entity.Employee;

@ApplicationScoped
//@Dependent
public class DatabaseService {

	@PersistenceContext 
	private EntityManager em;
	
	public DatabaseService() {
	}
	
	public List<Employee> findAllEmployees(){
		@SuppressWarnings("unchecked")
		List<Object[]> results = em.createNativeQuery("SELECT persId, firstname, name, birthday FROM "
				+ "Employee ").getResultList();
		
		List<Employee> emps = new ArrayList<>();
        for (Object[] result : results) {
        	Employee emp = new Employee();
        	emp.setPersId(Long.valueOf(result[0].toString()));
        	emp.setFirstname(String.valueOf(result[1]));
        	emp.setName(String.valueOf(result[2]));
        	emp.setBirthday(LocalDate.parse(result[3].toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        	emps.add(emp);
        }
        return emps;
	}

    @Transactional 
    public void createDummyEmployees() {
        Employee emp = new Employee();
        emp.setFirstname("Karl");
        emp.setName("Meyer");
        emp.setBirthday(LocalDate.now());
        em.persist(emp);
        
        emp = new Employee();
        emp.setFirstname("Fiona");
        emp.setName("Meyer");
        emp.setBirthday(LocalDate.now());
        em.persist(emp);
        
        emp = new Employee();
        emp.setFirstname("Tim");
        emp.setName("Schmidt");
        emp.setBirthday(LocalDate.now());
        em.persist(emp);
    }
	
}
