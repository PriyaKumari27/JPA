package com.cg.demojpa.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.cg.demojpa.dto.Address;
import com.cg.demojpa.dto.Department;
import com.cg.demojpa.dto.Employee;
import com.cg.demojpa.dto.Project;
import com.cg.demojpa.service.EmployeeSeriveImpl;
import com.cg.demojpa.service.EmployeeService;

public class EmployeeMain {
	public static void main(String[] args) throws ParseException {
	
	EmployeeService service=new EmployeeSeriveImpl();
	Scanner scanner=new Scanner(System.in);
	int choice;
	do {
		displayOptions();
		System.out.println("Enter your choice:");
		choice = scanner.nextInt();
		
		switch(choice) {
		case 1:
			System.out.println();
			System.out.println("Enter id");
			int id = scanner.nextInt();
			System.out.println("Enter name");
			String name = scanner.next();
			System.out.println("Enter Salary");
			double sal = scanner.nextDouble();
			System.out.println("Enter date of joining");
			String date=scanner.next();
			SimpleDateFormat st=new SimpleDateFormat("yyyy/MM/dd");
			Date dateNew=st.parse(date);
			System.out.println("Enter City");
			String city=scanner.next();
			System.out.println("Enter State");
			String state=scanner.next();
			System.out.println("Enter pincode");
			int pincode=scanner.nextInt();
			System.out.println("Enter Project Id");
			int pid=scanner.nextInt();
			System.out.println("Enter Project Name");
			String pname=scanner.next();
			System.out.println("Enter Project Cost");
			double pcost=scanner.nextDouble();
			System.out.println("Enter Department Id");
			int depId=scanner.nextInt();
			System.out.println("Enter Department Name");
			String depName=scanner.next();
			
			
			
			Address addr=new Address();
			
			Project pro=new Project();
			Department dep=new Department();
			
			addr.setCity(city);
			addr.setState(state);
			addr.setPincode(pincode);
			
			pro.setProjId(pid);
			pro.setProjName(pname);
			pro.setProjCost(pcost);
			
			dep.setDepId(depId);
			dep.setDepName(depName);
			
			
		
			Employee emp =new Employee();
			emp.setEmpId(id);
			emp.setEmpName(name);
			emp.setEmpSalary(sal);
			emp.setDateOfJoining(dateNew);
			emp.setAddr(addr);
			
			
			emp.setProj(pro);
			emp.setDep(dep);
		
			service.addEmployee(emp);
			break;
		
		case 2:
			System.out.println("Enter employee id to remove");
			int id1=scanner.nextInt();
			
			service.remove(id1);
			System.out.println("Employee with id "+ id1 + " removed from the Database");
			break;
			
			
		case 3:
			List<Employee> empList=service.showAll();
			
			for(Employee e: empList) {
				System.out.println(e);
				
			}
			break;
			
		case 4:
				System.out.println("Enter min value");
				double min = scanner.nextDouble();
				System.out.println("Enter max value");
				double max =scanner.nextDouble();
				List<Employee> empList1=service.findBetweenSalary(min, max);
				
				for(Employee e: empList1) {
					System.out.println(e);
					
				}
				
			
		case 5: 
			System.exit(0);
			break;
			
		default: 
			System.out.println("Enter choice between 1 and 5");
			
		}
	}while(choice != 5);
		
		
	
	
	}
		
	
	public static void displayOptions() {
		System.out.println("1. Add Employee");
		System.out.println("2. Remove Employee");
		System.out.println("3. Show Employee List");
		System.out.println("4. Show Employee List having salary in the range");
		System.out.println("5. Exit");
	}

	
	
}
