package com.crud.project.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crud.project.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
		
		Optional<Employee> findByEmpname(String empname);
	    @Query("SELECT e FROM Employee e where e.salary >=:sal1 and e.salary<=:sal2")
	    List<Employee> searchProducts(@Param("sal1") int sal1,@Param("sal2") int sal2);
	    
	    @Query("SELECT s FROM Employee s WHERE s.salary >=:c")
	    List<Employee> findBySalary(@Param("c") int salary);


}
