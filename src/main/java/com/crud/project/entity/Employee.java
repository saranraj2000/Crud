package com.crud.project.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Entity
@Builder
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long empid;
	
	@Column(nullable = false)
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]{2,10}",message="Alphabets are only allowed min 2 to 10 characters are allowed")
	private String empname;
	
	private int salary;
	
	@NotEmpty
	@Column(unique = true)
	@Email
	private String email;
	
	@OneToMany(targetEntity = Department.class,cascade = CascadeType.ALL)
	@JoinColumn(name="empid_fk",referencedColumnName = "empid")
	List<Department> department;

	@Column(unique = true)
	@NotEmpty
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",message="password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit")
	private String password;


	public Long getEmpid() {
		return empid;
	}


	public void setEmpid(Long empid) {
		this.empid = empid;
	}


	public String getEmpname() {
		return empname;
	}


	public void setEmpname(String empname) {
		this.empname = empname;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Department> getDepartment() {
		return department;
	}


	public void setDepartment(List<Department> department) {
		this.department = department;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Employee(Long empid,
			@NotEmpty @Pattern(regexp = "^[a-zA-Z]{2,10}", message = "Alphabets are only allowed min 2 to 10 characters are allowed") String empname,
			@NotEmpty int salary, @NotEmpty @Email String email, List<Department> department,
			@NotEmpty @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit") String password) {
		super();
		this.empid = empid;
		this.empname = empname;
		this.salary = salary;
		this.email = email;
		this.department = department;
		this.password = password;
	}


	public Employee() {
		super();
	}


	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", salary=" + salary + ", email=" + email
				+ ", department=" + department + ", password=" + password + "]";
	}


		
	
	


			
		
}