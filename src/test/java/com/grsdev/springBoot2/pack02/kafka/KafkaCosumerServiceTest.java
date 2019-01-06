package com.grsdev.springBoot2.pack02.kafka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaCosumerServiceTest {
	
	@Autowired
	private KafkaConsumerService kafkaConsumerService;
	
	@Test
	public void shouldConsumeMessageFromStart() {
		
		kafkaConsumerService.readAllMessages("6iykfcd3-topic1").forEach(System.out::println);
	}
}
