package com.grsdev.springBoot2.pack02.kafka;
/*
import org.apache.kafka.common.TopicPartition;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

@Service
public class KafkaConsumerService implements ConsumerSeekAware{
	
	
	@KafkaListener(topics="6iykfcd3-topic1")
	public void cosumer(String message) {
		
		System.out.println("cosumer 1 : " + message);
	}
	
	@KafkaListener(topics="6iykfcd3-topic1")
	public void cosumer2(String message) {
		
		System.out.println("cosumer 2 : " + message);
	}

	public Collection<String> readAllMessages(String string) {
		
		return Arrays.asList();
	}

	@Override
	public void registerSeekCallback(ConsumerSeekCallback callback) {
		
	}

	@Override
	public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
		
		assignments.keySet()
				   .stream()
				   .forEach(t-> callback.seekToBeginning("6iykfcd3-topic1", t.partition()));
	}

	@Override
	public void onIdleContainer(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {
		
	}

}*/
