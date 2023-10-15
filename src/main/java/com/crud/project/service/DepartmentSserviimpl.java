package com.crud.project.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.project.Repository.DepartmentRepo;
import com.crud.project.entity.Department;

@Service
public class DepartmentSserviimpl implements DepartmentService {
	
	
	@Autowired
	DepartmentRepo departmentRepo;
	@Override
	public Department adddepartment(Department department) {
		return departmentRepo.save(department);
	}

	@Override
	public List<Department> getdepartment(String deptid) {
		
		return departmentRepo.findByDeptid(deptid);
	}

}
