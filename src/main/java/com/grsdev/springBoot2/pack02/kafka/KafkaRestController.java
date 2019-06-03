package com.grsdev.springBoot2.pack02.kafka;

/*
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(path="/kafka")
public class KafkaRestController {
	
	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	private KafkaProducerService service;
	
	public KafkaRestController(KafkaProducerService service) {
		this.service=service;
	}
	
	@PostMapping
	public void sendMessage(String topic,String message) throws InterruptedException, ExecutionException {
		service.sendMessage(topic, message);
		logger.info("message sent to kafka");
	}
	
	
}
*/
