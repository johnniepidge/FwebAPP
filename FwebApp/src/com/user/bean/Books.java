package com.user.bean;

public class Books {
	private Integer id;
	private String Author;
	private String Title;
	
	
	public Books(Integer id, String author, String title) {
		super();
		this.id = id;
		Author = author;
		Title = title;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getAuthor() {
		return Author;
	}


	public void setAuthor(String author) {
		Author = author;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}
	
	
	

}
