package com.cg.demojpa.service;

import java.util.List;

import com.cg.demojpa.dao.EmployeeDao;
import com.cg.demojpa.dao.EmployeeDaoImpl;
import com.cg.demojpa.dto.Employee;

public class EmployeeSeriveImpl implements EmployeeService{
	EmployeeDao dao=new EmployeeDaoImpl();

	@Override
	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		return dao.save(emp);
	}

	@Override
	public List<Employee> showAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public void remove(Integer empId) {
		// TODO Auto-generated method stub
		 dao.remove(empId);
		
	}

	@Override
	public List<Employee> findBetweenSalary(double min, double max) {
		// TODO Auto-generated method stub
		return dao.findBetweenSalary(min, max);
	}
	

}
