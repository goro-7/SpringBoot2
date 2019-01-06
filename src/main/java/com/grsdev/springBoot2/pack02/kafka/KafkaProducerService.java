package com.grsdev.springBoot2.pack02.kafka;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

@Service
public class KafkaProducerService {
	
	private final KafkaTemplate<String, String> kafka;
	
	@Autowired
	public KafkaProducerService(KafkaTemplate<String, String> kafka) {
		this.kafka=kafka;
	}
	
	public void sendMessage(String topic, String message) throws InterruptedException, ExecutionException {
		
		ListenableFuture<SendResult<String, String>> send = kafka.send(topic,message);
		System.out.println(send.get());
	}
	
	
}
