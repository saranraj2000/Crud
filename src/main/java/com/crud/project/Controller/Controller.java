package com.crud.project.Controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.crud.project.Exception.EmployeeNotFoundException;
import com.crud.project.entity.Department;
import com.crud.project.entity.Employee;
import com.crud.project.service.DepartmentService;
import com.crud.project.service.EmployeeService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/crud")
@Validated
public class Controller {
	
	@Autowired
	 EmployeeService employeeService;
	
	@Autowired
	DepartmentService departmentservice;
	
	@PostMapping("/addemployee")
	public String addemp(@Valid @RequestBody Employee employee) {
		employeeService.addemployee(employee);
		return "Employee is added";
	}
	
		
	@GetMapping("/employees/{empid}")
	public Optional<Employee> getemployee(@PathVariable ("empid") Long empid){
		if(employeeService.getemployee(empid).isEmpty() ) {
			throw new EmployeeNotFoundException("Employee is not found with id " +empid);
		}
		return employeeService.getemployee(empid);
		
	}
	@GetMapping("/employeename/{empname}")
	public Optional<Employee> getEmployeebyname(@PathVariable ("empname") String empname){
		if(employeeService.getempname(empname).isEmpty()) {
			throw new EmployeeNotFoundException("no"+empname);
			}
		return employeeService.getempname(empname);
			}
	
	@GetMapping("/allemployee")
	public List<Employee> getallemploye(){
		if(employeeService.getallemployee().isEmpty()) {
			throw new EmployeeNotFoundException("Empoyee data is empty");
		}
		return (List<Employee>) employeeService.getallemployee();
	}
	
	

	@PutMapping("updateemployee/{empid}")
	public String updateemployee(@PathVariable("empid") Long empid, @RequestBody Employee updateemp) {
		Optional<Employee> existemployee=employeeService.getemployee(empid);
		
		if(existemployee.isPresent()) {
			Employee updateemployee =existemployee.get();
			
			updateemployee.setEmpname(updateemp.getEmpname());
			updateemployee.setEmail(updateemp.getEmail());
			updateemployee.setPassword(updateemp.getPassword());
			updateemployee.setDepartment(updateemp.getDepartment());
			
			employeeService.updateemployee(empid, updateemployee);
			return "Employee" +empid+ "is updated";

		}else {
			throw new EmployeeNotFoundException("There is now employee with this id"+ empid);
		}
	}

	
	
	
	@DeleteMapping("/delemployee/{empid}")
	public String deleteemployee(@PathVariable ("empid") Long empid )throws EmployeeNotFoundException {
		
		Optional<Employee> emp=employeeService.getemployee(empid);
		if(emp.isPresent()) {
			employeeService.deleteemployee(empid);
		}else {
			throw new EmployeeNotFoundException("There is no employe found in this id " + empid);
		}
		
				return "employee deleted";
	}
	
	
	
	@PostMapping("/createdept")
	public String adddept(@RequestBody Department department) {
		departmentservice.adddepartment(department);
		return "department is created";
		
	}

	@GetMapping("/search/{sal1}/{sal2}")
	public ResponseEntity<List<Employee>> searchproduct(@PathVariable ("sal1") int sal1,@PathVariable ("sal2") int sal2){
		List<Employee> e = employeeService.search(sal1, sal2);
		for(Employee em:e) {
			
		}
		return ResponseEntity.ok(employeeService.search(sal1, sal2));
	}
	
	@GetMapping("/department/{deptid}")
	public List<Department> getdepartmentid(@PathVariable ("deptid") String deptid){
		if(departmentservice.getdepartment(deptid).isEmpty()) {
			throw new EmployeeNotFoundException("No departments"+deptid);
		
	}
		return departmentservice.getdepartment(deptid);
		
	}
	
	@GetMapping("/getsalary/{salary}")
	 public List<Employee> getlimitsalary(@PathVariable int salary){
		return employeeService.getsalary(salary);
	}

}
