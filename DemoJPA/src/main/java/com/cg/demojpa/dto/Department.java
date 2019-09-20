package com.cg.demojpa.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import com.cg.demojpa.dto.Employee;

@Entity(name="dept_jpa")
public class Department {
	@Id
	@Column(name= "dep_id")
	private Integer depId;
	@Column(name= "emp_name")
	private String depName;
	@OneToMany
	@JoinColumn(name= "emp_id")
	
	private List<Employee> empList;
	
	public Department() {
		// TODO Auto-generated constructor stub
	}

	public Department(Integer depId, String depName, List<Employee> empList) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.empList = empList;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + ", empList=" + empList + "]";
	}
	
	
	
	
	
	
	
   
}
