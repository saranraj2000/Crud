package com.crud.project.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.crud.project.entity.Employee;

@DataJpaTest
public class EmployeeRepoTest {
	
	@Autowired
	EmployeeRepo employeeRepo;
	Employee employee;
	
	
//	@BeforeEach
//	void setUp() {
	public void saveEmployeeTest() {
		employee =new Employee();
		employee.setEmpname("saran");
		employee.setEmail("saranraj@gmail.com");
		employee.setSalary(10000);
		employee.setPassword("Saran@123444");
		employeeRepo.save(employee);
		Assertions.assertThat(employee.getEmpid()).isGreaterThan(0);
	}

}
