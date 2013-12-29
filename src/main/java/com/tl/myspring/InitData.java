package com.tl.myspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.tl.myspring.model.Author;
import com.tl.myspring.model.Book;
import com.tl.myspring.model.BookRepository;
import com.tl.myspring.model.Customer;
import com.tl.myspring.model.CustomerRepository;

@Component
public class InitData implements ApplicationListener<ContextRefreshedEvent> {
	@Autowired
	CustomerRepository repository;
	@Autowired
	BookRepository bookRepository;

	  @Override
	  public void onApplicationEvent(final ContextRefreshedEvent event) {

		  bookRepository.save(new Book("Angular JS", new Author("Tom", "Tang")));
		  
		  System.out.println(bookRepository.findAll());
		  
			// save a couple of customers
	        repository.save(new Customer("Tom", "Bauer"));
	        repository.save(new Customer("Chloe", "O'Brian"));
	        repository.save(new Customer("Kim", "Bauer"));
	        repository.save(new Customer("David", "Palmer"));
	        repository.save(new Customer("Michelle", "Dessler"));

	        // fetch all customers
	        Iterable<Customer> customers = repository.findAll();
	        System.out.println("Customers found with findAll():");
	        System.out.println("-------------------------------");
	        for (Customer customer : customers) {
	            System.out.println(customer);
	        }
	        System.out.println();

	        // fetch an individual customer by ID
	        Customer customer = repository.findOne(1L);
	        System.out.println("Customer found with findOne(1L):");
	        System.out.println("--------------------------------");
	        System.out.println(customer);
	        System.out.println();

	        // fetch customers by last name
	        List<Customer> bauers = repository.findByLastName("Bauer");
	        System.out.println("Customer found with findByLastName('Bauer'):");
	        System.out.println("--------------------------------------------");
	        for (Customer bauer : bauers) {
	            System.out.println(bauer);
	        }
		
	  }	
}
