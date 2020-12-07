package com.yashwant.springbootin10steps;

public class Book {

	
	private int id;
	private int serialNo;
	private String name;
	private String author;
	
	public Book(int id, int serialNo, String name, String author) {
		super();
		this.id = id;
		this.serialNo = serialNo;
		this.name = name;
		this.author = author;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", serialNo=" + serialNo + ", name=" + name + ", author=" + author + "]";
	}
}
	
	
	