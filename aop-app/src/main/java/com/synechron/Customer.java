package com.synechron;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void buy(String item) {
		//logger.info
		System.out.println("*** " + name + " is shopping for " + item);
		//logger.info
	}
}
