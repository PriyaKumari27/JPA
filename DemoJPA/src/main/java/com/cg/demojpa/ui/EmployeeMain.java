package com.cg.demojpa.ui;

import java.util.List;
import java.util.Scanner;

import com.cg.demojpa.dto.Employee;
import com.cg.demojpa.service.EmployeeSeriveImpl;
import com.cg.demojpa.service.EmployeeService;

public class EmployeeMain {
	public static void main(String[] args) {
	
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
		
			Employee emp =new Employee();
			emp.setEmpId(id);
			emp.setEmpName(name);
			emp.setEmpSalary(sal);
		
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
			System.out.println("Enter choice between 1 and 3");
			
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
