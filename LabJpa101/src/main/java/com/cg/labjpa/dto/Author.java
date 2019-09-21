package com.cg.labjpa.dto;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Author_Table")
public class Author {
	
	@Id
	@Column(name="author_id")
	private BigInteger authorId;
	@Column(name="author_fname")
	private String firstName;
	@Column(name="author_mname")
	private String middleName;
	@Column(name="author_lname")
	private String lastName;
	@Column(name="author_contnumb")
	private BigInteger phoneNumber;
	
	private List<Book> bookList;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(BigInteger authorId, String firstName, String middleName, String lastName, BigInteger phoneNumber,
			List<Book> bookList) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.bookList = bookList;
	}

	public BigInteger getAuthorId() {
		return authorId;
	}

	public void setAuthorId(BigInteger authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public BigInteger getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(BigInteger phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<Book> getBookList() {
		return bookList;
	}

	public void setBookList(List<Book> bookList) {
		this.bookList = bookList;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", bookList=" + bookList + "]";
	}
	
	
	
	

}
