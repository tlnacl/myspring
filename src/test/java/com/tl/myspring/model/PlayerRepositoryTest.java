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

@ContextConfiguration(classes = ApplicationConfigration.class, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PlayerRepositoryTest {

	public Logger logger = LoggerFactory
			.getLogger(CustomerRepositoryTest.class);

	@Autowired
	PlayerRepository playerRepository;

	@Before
	public void setUp() {
		playerRepository.deleteAll();
		for (int i = 1; i <= 20; i++) {
			Player player = new Player();
			player.setFirstName("Tom" + i);
			player.setLastName("Tang");
			player.setTelephone("13888888888");
			playerRepository.save(player);
		}
	}

	@Test
	public void testCount() {
		logger.info("%%%%%%%%%%%%%");
		assertEquals(20, playerRepository.count());
	}

	// @Test
	// public void testBook() {
	// assertEquals("Tom",
	// bookRepository.findOne(1l).getAuthor().getFirstName());
	// }

}
