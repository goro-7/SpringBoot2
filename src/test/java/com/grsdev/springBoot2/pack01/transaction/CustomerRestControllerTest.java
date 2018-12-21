package com.grsdev.springBoot2.pack01.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerRestController.class)
public class CustomerRestControllerTest {
	
	@Autowired 
	private MockMvc mvc;
	
	@MockBean
	private CustomerRepo repo;
	
	@Test
	public void shouldReturn200() throws Exception {
		
		mvc.perform(MockMvcRequestBuilders.get("/customers")).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void shouldReturn201() throws Exception {
		
		String request = "{\"name\" : \"gaurav\"}";
		
		MvcResult result = mvc.perform(MockMvcRequestBuilders.post("/customers")
			.content(request)
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isCreated())
			.andExpect(MockMvcResultMatchers.header().exists("location"))
			.andReturn();
		
		System.out.println(result.getResponse());
		
	}

}
