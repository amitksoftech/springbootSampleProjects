package com.synechron;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class StockPriceService {

	@Autowired
	private List<String> stockPriceList;
	
	
	@JmsListener(destination = "StockPriceQueue")
	public void receiveMessage(String message) {
		stockPriceList.add(message);
	}
	
	
}
