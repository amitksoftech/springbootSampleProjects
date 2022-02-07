package com.synechron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StockReceiver {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@JmsListener(destination = "StockQueue")
	public void receiveMessage(String message) {
		//Ideally you will connect to Yahoo Finance or Google Finance to get the current price
		//For now, we'll generate a random number as the price
		double price = Math.random() * 1000;
		jmsTemplate.convertAndSend("StockPriceQueue", message + ":" + price);
		System.out.println("CMP of " + message + " is " + price);
	}
	
	@KafkaListener(topics = "StockTopic")
	public void receiveMessageFromKafka(String message) {
		//Ideally you will connect to Yahoo Finance or Google Finance to get the current price
		//For now, we'll generate a random number as the price
		double price = Math.random() * 1000;
		System.out.println("CMP (From Kafka) of " + message + " is " + price);
	}
}
