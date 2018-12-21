package com.grsdev.springBoot2.pack01.transaction;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.JsonNode;

@RestController
@RequestMapping(path="/customers")
public class CustomerRestController {
	
	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private CustomerService service;
	
	
	@GetMapping
	@ResponseStatus(code=HttpStatus.OK)
	public List<Customer> getListOfCustomers(){
		
		return repo.findAllCustomer();
	}
	
	@PostMapping
	public ResponseEntity<Object> addNewCustomer(@RequestBody JsonNode request,UriComponentsBuilder ucb,Boolean throwError) throws Exception {
		
		Customer customer = new Customer(request);
		
		repo.save(customer);
		
		URI uri = ucb.path("/customers/").path(customer.getCustomerId().toString()).build().toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	@DeleteMapping
	public void deleteAllCustomesAndAddress() {
		
		repo.deleteAllCustomer();
	}

}
