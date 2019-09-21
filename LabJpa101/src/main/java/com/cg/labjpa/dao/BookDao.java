package com.cg.labjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.labjpa.dto.Book;

public class BookDao implements IBookDao{

	
	EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("BookAuthor");
	
	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		
		EntityManager em=entityManagerFactory.createEntityManager() ;
		EntityTransaction transaction= em.getTransaction();
		transaction.begin();
		em.persist(book);
		
		return book;
	}

	@Override
	public List<Book> listOfBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeBook(Integer isbn) {
		// TODO Auto-generated method stub
		
	}
	

}
