package com.be.demo.common.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.be.demo.common.model.CustomBaseEntity;

@Component
public class CustomProducer {

	@Autowired
	@Qualifier("producerKafkaTemplate")
	KafkaTemplate<String, String> producerKafkaTemplate;

	@Autowired
	@Qualifier("producerObjKafkaTemplate")
	KafkaTemplate<String, CustomBaseEntity> producerObjKafkaTemplate;

	public void sendMessage(String msg) {
		producerKafkaTemplate.send("topic-test", msg);
	}

	public void sendMessage(String topic, CustomBaseEntity model) {
		producerObjKafkaTemplate.send(topic, model);
		System.err.println("Topic " + topic + "Data sended" + model);
	}

}
