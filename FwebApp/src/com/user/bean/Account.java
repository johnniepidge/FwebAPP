package com.user.bean;

import java.sql.Date;

public class Account {
		
	private Books Book;
	private User user;
	private Date date;
	
	public Books getBook() {
		return Book;
	}


	public void setBook(Books book) {
		Book = book;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	

}
