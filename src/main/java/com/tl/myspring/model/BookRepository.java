package com.tl.myspring.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Basic repository for CRUD operations on {@see Book books}.
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Long>{

//  /**
//   * Find a <code>Book</code> by ID.
//   *
//   * @param id the ID of the book.
//   * @return the book, or <code>null</code> if no book is found.
//   */
//  Book findById(long id);
//
//  List<Book> findAll();
//
//  Book save(Book book);
//
//  void delete(long id);
}
