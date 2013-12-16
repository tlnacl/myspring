package com.tl.myspring.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

import com.tl.myspring.ApplicationConfigration;

//@ContextConfiguration(locations = "classpath:test-context.xml")//file:src/main/webapp/WEB-INF
@ContextConfiguration(classes=ApplicationConfigration.class, loader=AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class CustomerRepositoryTest {
	
	public Logger logger = LoggerFactory.getLogger(CustomerRepositoryTest.class);

	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	BookRepository bookRepository;
	
	@Before
    public void setUp() {
		customerRepository.deleteAll();
		for (int i = 1; i <= 20; i++) {
			Customer c = new Customer("firstName"+i, "lastName" +i);
			logger.info(c.toString());
			customerRepository.save(c);
		}
//		customerRepository.
		bookRepository.deleteAll();
		
		Book book = new Book("Spring", new Author("Tom", "Tang"));
		bookRepository.save(book);
		
	}
	
	@Test
    public void testCount() {
		logger.info("%%%%%%%%%%%%%");
		assertEquals(20,customerRepository.count());
		assertEquals(1,bookRepository.count());
		logger.info(bookRepository.findAll().toString());
	}
	
//	public void testBook() {
//		assertEquals("Tom", bookRepository.findOne(1l).getAuthor().getFirstName());
//	}
}
