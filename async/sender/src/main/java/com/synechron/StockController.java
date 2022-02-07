package com.synechron;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private List<String> stockPriceList;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@GetMapping("/stock/{symbol}")
	public String getPrice(@PathVariable String symbol) {
		jmsTemplate.convertAndSend("StockQueue", symbol);
		return "You'll receive the stock value soon";
	}
	
	@GetMapping("/stockkafka/{symbol}")
	public String getPriceFromKafka(@PathVariable String symbol) {
		kafkaTemplate.send("StockTopic", symbol);
		return "You'll receive the stock value soon";
	}
	
	@GetMapping("/stockprices")
	public List<String> getStockPrices() {
		return stockPriceList;
	}
}
