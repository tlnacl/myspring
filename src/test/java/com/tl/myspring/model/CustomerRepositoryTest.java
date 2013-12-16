package com.tl.myspring.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

	@Autowired
	CustomerRepository customerRepository;
	
	@Before
    public void setUp() {
		customerRepository.deleteAll();
		for (int i = 1; i <= 20; i++) {
			Customer c = new Customer("firstName"+i, "lastName" +i);
			System.out.println(c);
			customerRepository.save(c);
		}
	}
	
	@Test
    public void testCount() {
		assertEquals(20,customerRepository.count());
	}
}
