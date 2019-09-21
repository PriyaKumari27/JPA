package com.cg.jpalab.dao;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.cg.jpalab.dto.Author;
import com.cg.jpalab.dto.Book;

public class AuthorDaoImpl implements AuthorDao {

	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction tx;

	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("jpalab");
		entityManager = entityManagerFactory.createEntityManager();
		tx = entityManager.getTransaction();
	}

	public AuthorDaoImpl() {
		super();
	}

	@Override
	public Author saveAuthor(Author author) {
		tx.begin();
		author.getBookList().forEach(book -> {
			book.getAuthor().add(author);
		});
		entityManager.persist(author);
		tx.commit();
		return author;
	}

	@Override
	public Author findAuthor(BigInteger authorId) {
		return entityManager.find(Author.class, authorId);
	}

	@Override
	public Author removeAuthor(BigInteger authorId) {
		Author author = entityManager.find(Author.class, authorId);
		if (author!= null) {
			try{
				tx.begin();
			
			author.getBookList().forEach(book -> {
				book.getAuthor().remove(author);
			});
			entityManager.remove(author);
			tx.commit();
		
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
			return author;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> findAllAuthor() {
		Query query = entityManager.createQuery("FROM Author");
		List<Author> authList = query.getResultList();
		return authList;
	}

	@Override
	public Book saveBook(Book book) {
		tx.begin();
		book.getAuthor().forEach(author ->{
			author.getBookList().add(book);
		});
		entityManager.persist(book);
		tx.commit();
		return book;
	}

	@Override
	public Book findBook(BigInteger bookID) {
		return entityManager.find(Book.class, bookID);
	}

	@Override
	public List<Book> findAllBook() {
		Query query = entityManager.createQuery("FROM Book");
		@SuppressWarnings("unchecked")
		List<Book> bookList = query.getResultList();
		return bookList;
	}

}
