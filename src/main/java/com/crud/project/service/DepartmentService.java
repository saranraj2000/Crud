package com.crud.project.service;

import java.util.List;
import java.util.Optional;

import com.crud.project.entity.Department;

public interface DepartmentService {
	
	public Department adddepartment(Department department);
	public List<Department> getdepartment(String deptid);
	

}
