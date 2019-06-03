package com.grsdev.springBoot2.pack01.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class CustomerRepo {

	@Autowired
	private EntityManager em;
	
	@Transactional
	public void save(Customer customer) {
		System.out.println("save transaction : " + TransactionAspectSupport.currentTransactionStatus().toString());
		em.persist(customer);
	}

	public List<Customer> findAllCustomer() {
		List<Customer> resultList = em.createNamedQuery("findAll",Customer.class).getResultList();
		
		resultList.forEach(t->{
			
			List<Object[]> result = em.createNativeQuery("select * from address where customer_id="+t.getCustomerId()).getResultList();
			
			if(!result.isEmpty()) {
				Object[] objects = result.get(0);
				
				Address address = new Address();
				address.setStreet((String) objects[1]);
				address.setAddressId((BigDecimal) objects[0]);
				
				t.setAddress(address);
			}
			
		});
		
		return resultList;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void save(Address address) {
		em.persist(address);
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteAllCustomer() {
		em.createNativeQuery("delete from address").executeUpdate();
		em.createNativeQuery("delete from customer").executeUpdate();
	}
	

}
