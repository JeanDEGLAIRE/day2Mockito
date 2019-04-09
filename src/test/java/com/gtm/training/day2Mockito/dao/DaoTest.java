package com.gtm.training.day2Mockito.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.gtm.training.day2Mockito.model.Client;

@SpringBootTest
public class DaoTest {
	
	@Autowired
	private IDao dao;
	
	@BeforeEach
	void init() {
		dao.save(new Client("Jean", "123"));
	}
		
	@Test
	public void testInsert() {		
		Client client = new Client("Roger", "000015");		
		Client result = dao.save(client);		
		Assertions.assertEquals(client, result);		
	}
	
	@Test
	void testGet() {
		Client result = dao.getByName("Jean");
		Assertions.assertEquals("Jean", result.getName());
		Assertions.assertEquals("123", result.getAccountNumber());
	}
	
	@Test
	void testDelete() {
		dao.deleteByName("Jean");
		Client nullClient = dao.getByName("Jean");
		Assertions.assertNull(nullClient);
	}

}
