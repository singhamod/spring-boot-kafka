package com.hello.world.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${app.kafka.topic}")
	private String topic;

	public void sendMessage(String message) {
		this.kafkaTemplate.send(topic, message);
	}
}
