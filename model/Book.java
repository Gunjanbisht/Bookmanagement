package com.bookmanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Book")

public class Book {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY )

private int id;

@Column(name = "title")
private String title;

@Column(name = "author")
private String author;


public long getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;	
}
@Override
public String toString() {
	return "Book [id=" + id + ", title=" + title + ", author=" + author + "]";
}

}


