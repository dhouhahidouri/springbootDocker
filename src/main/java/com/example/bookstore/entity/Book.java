package com.example.bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private String auther;
private String price;
/*@ManyToOne
@JoinColumn(name = "author_id")  // Adjust the column name as per your database schema
private Author author;

//Update getter and setter
public Author getAuthor() {
 return author;
}

public void setAuthor(Author author) {
 this.author = author;
}*/
public Book(int id, String name, String auther, String price) {
	super();
	this.id = id;
	this.name = name;
	this.auther = auther;
	this.price = price;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAuther() {
	return auther;
}
public void setAuther(String auther) {
	this.auther = auther;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}

}
