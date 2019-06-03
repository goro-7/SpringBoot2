package com.grsdev.springBoot2.pack01.transaction;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
