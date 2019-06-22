package com.grsdev.springBoot2.pack01.transaction;

import org.assertj.core.api.Assertions;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
public class CustomerRepoTest {
	
	@Autowired
	private CustomerRepo repo;
	
	@Test
	@Transactional(propagation=Propagation.REQUIRED)
	public void shouldSaveCustomer() {
		
		
//		System.out.println("shouldSaveCustomer transaction : " + TransactionAspectSupport.currentTransactionStatus().toString());
		
		Customer customer = new Customer();
		customer.setName("gaurav");
		repo.save(customer);
		
		Address address = new Address();
		address.setCustomer(customer);
		address.setStreet("east-street");
		
		repo.save(address);
		
	}
	
	@Test
	public void shouldShowAllCustomer() {
		
		List<Customer> customers = repo.findAllCustomer();
		System.out.println(customers);
		Assertions.assertThat(customers).isNotNull().isNotEmpty();
	}
	
	
}
