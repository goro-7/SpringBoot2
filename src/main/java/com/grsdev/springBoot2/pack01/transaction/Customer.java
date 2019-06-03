package com.grsdev.springBoot2.pack01.transaction;

import com.fasterxml.jackson.databind.JsonNode;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NamedNativeQuery(name="findAll",query="select * from customer",resultClass=Customer.class)
public class Customer {
	
	@Id
	@GeneratedValue
	private BigDecimal customerId;
	
	private String name;
	
	@OneToOne(mappedBy="customer")
	private Address address;
	
	public Customer() {
	}

	public Customer(JsonNode request) {
		this.setName(request.findValue("name").asText());
	}

	public Customer(String string) {
		this.name=string;
	}

	public BigDecimal getCustomerId() {
		return customerId;
	}

	public void setCustomerId(BigDecimal customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", address=" + address + "]";
	}
	
}
