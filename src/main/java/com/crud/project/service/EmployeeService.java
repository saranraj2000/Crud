package com.crud.project.service;

import java.util.List;
import java.util.Optional;

import com.crud.project.entity.Employee;

public interface EmployeeService {
	
	public Employee addemployee(Employee employee);
	public Optional<Employee> getemployee(Long empid);
	public Optional<Employee> getempname(String empname);
	public List<Employee> getallemployee();
	public void deleteemployee(Long empid);
	public Employee updateemployee(Long empid,Employee employee);
	
	public List<Employee> search(int sal1,int sal2);
	
	public List<Employee> getsalary(int salary);

}
