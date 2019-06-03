package com.grsdev.springBoot2.pack01.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static java.lang.System.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	private CustomerService service;
	
	@Test
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void test01() throws Exception {
		
		out.println(">>> CustomerServiceTest.test01 : "+ TransactionSynchronizationManager.getCurrentTransactionName());
		
		service.save(new Customer("gaurav"), new Address("street"), false);
	}
	
}
