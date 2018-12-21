package com.grsdev.springBoot2.pack01.transaction;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CustomerRestControllerIntegrationTest {
	
	@Autowired
	private TestRestTemplate rest;
	
	@Test
	public void shouldReturnCustomerList() {
		
		ResponseEntity<String> response = rest.getForEntity("/customers", String.class);
		assertThat(response).isNotNull().extracting(ResponseEntity::getStatusCode).isEqualTo(HttpStatus.OK);
		out.println(">>> "+response.getBody());
		
	}
	
	@Test
	public void shouldSaveCustomer() {
		
		String requestString = "{\"name\" : \"gaurav\" , \"street\" : \"east street\"}";
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> request = new HttpEntity(requestString,headers);
		
		ResponseEntity<String> response = rest.exchange("/customers", HttpMethod.POST,request,String.class);
//		ResponseEntity<String> response = rest.postForEntity("/customers", requestString, String.class);
		
		assertThat(response).isNotNull().extracting(ResponseEntity::getStatusCode).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getHeaders()).containsKey("Location");
		
		out.println(">>> response : "+response);
	}
	
	@Test
	public void shouldDeleteAllCustomers() {
		
		rest.delete("/customers");
	}
	

}
