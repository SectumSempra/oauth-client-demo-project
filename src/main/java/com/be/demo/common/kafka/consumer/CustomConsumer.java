package com.be.demo.common.kafka.consumer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.be.demo.common.model.Employee;
import com.be.demo.common.model.Region;
import com.be.demo.common.repository.RegionRepository;

@Component
public class CustomConsumer {

	@Autowired
	RegionRepository regionRepository;

	public List<String> messageList = new ArrayList<>();

	public List<Employee> messageEmpList = new ArrayList<>();

	@KafkaListener(topics = "topic-test", groupId = "group-test")
	public void listen(String message) {
		messageList.add(message);
		System.out.println("Received Messasge in group - group-id: " + message);
	}

	@KafkaListener(topics = "topic-emp", groupId = "group-obj-test", containerFactory = "kafkaListenerObjContainerFactory")
	public void listen(Employee model) {
		messageEmpList.add(model);
		System.err.println("Received EMP Messasge in group - group-id: " + model);
	}

	@KafkaListener(topics = "topic-region", groupId = "group-obj-test", containerFactory = "kafkaListenerObjContainerFactory")
	public void regionlisten(Region model) {
		Region saved = regionRepository.save(model);
		System.err.println("topic-region comsumed , data :" + saved);
	}

}
