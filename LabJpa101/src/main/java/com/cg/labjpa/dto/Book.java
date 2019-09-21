package com.cg.labjpa.dto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Book_Table")
public class Book {
	@Id
	@Column(name="book_isbn")
	private BigInteger isbn;
	@Column(name="book_title")
	private String bookTitle;
	@Column(name="book_price")
	private BigDecimal price;
	
	private List<Author> authorList;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(BigInteger isbn, String bookTitle, BigDecimal price, List<Author> authorList) {
		super();
		this.isbn = isbn;
		this.bookTitle = bookTitle;
		this.price = price;
		this.authorList = authorList;
	}

	public BigInteger getIsbn() {
		return isbn;
	}

	public void setIsbn(BigInteger isbn) {
		this.isbn = isbn;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public List<Author> getAuthorList() {
		return authorList;
	}

	public void setAuthorList(List<Author> authorList) {
		this.authorList = authorList;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", bookTitle=" + bookTitle + ", price=" + price + ", authorList=" + authorList
				+ "]";
	}
	
	
	
	
	
	
	
	 

}
