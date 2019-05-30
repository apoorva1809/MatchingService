package com.matchingservices.kafka;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Service
public class KafkaConsumer {
	
	private static final Logger logger=LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "users")
	public void listen(String reservDetails) throws JsonParseException, JsonMappingException, IOException {
		
		logger.info("In listener");
		
		NotifyEmails cistNotification=new NotifyEmails();
		
		cistNotification.notifyCustomer(reservDetails);
		
		logger.info("Notify is done");
	}
	

}
