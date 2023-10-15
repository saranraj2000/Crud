package com.crud.project;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.crud.project.Repository.EmployeeRepo;
import com.crud.project.entity.Employee;

@DataJpaTest
public class EmployeeRepoTest {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Test
	public void saveEmployeeTest() {
		Employee employee =Employee.
				
	}
	
	
		

}
