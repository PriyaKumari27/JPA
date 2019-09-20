package com.cg.demojpa.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;
import com.cg.demojpa.dto.Employee;
import com.cg.demojpa.dto.Project;

public class EmployeeDaoImpl implements EmployeeDao{
 
	EntityManagerFactory entityFactory= Persistence.createEntityManagerFactory("demo_jpa");

	@Override
	public Employee save(Employee emp) {
		// TODO Auto-generated method stub
		
		EntityManager em=entityFactory.createEntityManager();
		EntityTransaction tran=em.getTransaction();
		tran.begin();
		//em.persist(emp.getProj()); //Not used bcz we can have many classes
 		em.persist(emp);
//		em.flush();                                      // If we are not using commit
		tran.commit();
		return emp;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		EntityManager em=entityFactory.createEntityManager();
		Query query= em.createQuery("FROM Employee ");
		
	    List<Employee> empList=query.getResultList();
		
		return empList;
	}

	@Override
	public void remove(Integer empId) {
		// TODO Auto-generated method stub
		EntityManager em=entityFactory.createEntityManager();
		Employee empRemove=em.find(Employee.class, empId);
		EntityTransaction tran=em.getTransaction();
		tran.begin();
		em.remove(empRemove);
		tran.commit();
		
	}

	@Override
	public List<Employee> findBetweenSalary(double min, double max) {
		// TODO Auto-generated method stub
		EntityManager em=entityFactory.createEntityManager();
		Query query= em.createQuery("FROM Employee WHERE empSalary BETWEEN : first AND :second");
		query.setParameter("first", min);
		query.setParameter("second", max);
		List<Employee> empList=query.getResultList();
		return empList;
	}

	
}
