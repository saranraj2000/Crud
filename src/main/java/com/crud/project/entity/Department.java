package com.crud.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long slno;
	
	@NotEmpty
	private String deptid;
	
	
	@NotEmpty
	@Pattern(regexp = "^[a-zA-z0-9]{3}",message="department name should be only 3 characters and no special characters")
	private String deptname;


	public Long getSlno() {
		return slno;
	}


	public void setSlno(Long slno) {
		this.slno = slno;
	}


	public String getDeptid() {
		return deptid;
	}


	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}


	public String getDeptname() {
		return deptname;
	}


	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}


	public Department(Long slno, @NotEmpty String deptid,
			@NotEmpty @Pattern(regexp = "^[a-zA-z0-9]{3}", message = "department name should be only 3 characters and no special characters") String deptname) {
		super();
		this.slno = slno;
		this.deptid = deptid;
		this.deptname = deptname;
	}


	public Department() {
		super();
	}


	@Override
	public String toString() {
		return "Department [slno=" + slno + ", deptid=" + deptid + ", deptname=" + deptname + "]";
	}
	


		

}
