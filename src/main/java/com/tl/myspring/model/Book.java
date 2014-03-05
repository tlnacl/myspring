package com.tl.myspring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book extends BaseEntity{
  private String title;
  @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  private Author author;

  public Book() {
  }

  public Book(String title, Author author) {
    this.title = title;
    this.author = author;
  }
  
  public Book(String title) {
	  this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }
}
