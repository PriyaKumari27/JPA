package com.cg.demojpa.service;

import java.util.List;

import com.cg.demojpa.dto.Employee;

public interface EmployeeService {
	public Employee addEmployee(Employee emp);
	public List<Employee> showAll();
	public void remove(Integer empId);
	public List<Employee> findBetweenSalary(double min, double max);
}
