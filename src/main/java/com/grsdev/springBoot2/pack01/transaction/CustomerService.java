package com.grsdev.springBoot2.pack01.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import static java.lang.System.*;

@Service
public class CustomerService {
	
	@Autowired CustomerRepo repo;
	
	@Transactional(propagation=Propagation.NESTED,rollbackFor=Exception.class)
	public void save(Customer customer, Address address, Boolean throwError) throws Exception {
		
		
		out.println(">>> CustomerService.save : "+ TransactionSynchronizationManager.getCurrentTransactionName());
		
		repo.save(customer); address.setCustomer(customer);
		
		if(Boolean.TRUE.equals(throwError)) {
			throw new Exception("request said throw exception");
		}
		
		repo.save(address);
		
	}
	

}
