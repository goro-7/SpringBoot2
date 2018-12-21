package com.grsdev.springBoot2.pack01.transaction;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@RunWith(SpringRunner.class)
@SpringBootTest
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
