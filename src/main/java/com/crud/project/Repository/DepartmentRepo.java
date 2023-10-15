package com.crud.project.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.project.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
 List<Department> findByDeptid(String deptid);

}
