package com.cg.labjpa.dao;

import java.util.List;

import com.cg.labjpa.dto.Book;

public interface IBookDao {
	
	public Book saveBook(Book book);
	public List<Book> listOfBooks();
	public void removeBook(Integer isbn);
	

}
