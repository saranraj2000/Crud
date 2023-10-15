package com.crud.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.project.Repository.EmployeeRepo;
import com.crud.project.entity.Employee;

@Service
public class EmployeeServiceimpl implements EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public Employee addemployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}
	

	@Override
	public List<Employee> getallemployee() {
		
		return employeeRepo.findAll();
	}

	@Override
	public void deleteemployee(Long empid) {
		
		employeeRepo.deleteById(empid);
		
	}

	@Override
	public Employee updateemployee(Long empid, Employee employee) {
		Employee emp=employeeRepo.findById(empid).get();
		return employeeRepo.save(employee);
	}


	@Override
	public Optional<Employee> getemployee(Long empid) {
		
		
			return employeeRepo.findById(empid);
				
		
	}


	@Override
	public List<Employee> search(int sal1,int sal2) {
		List<Employee> emp=employeeRepo.searchProducts(sal1,sal2);
		return emp;
	}


	@Override
	public Optional<Employee> getempname(String empname) {
		
		return employeeRepo.findByEmpname(empname);
	}


	@Override
	public List<Employee> getsalary(int salary) {
		
		return employeeRepo.findBySalary(salary);
	}


	
	
}
