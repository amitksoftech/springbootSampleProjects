package com.synechron;

import org.springframework.stereotype.Component;

@Component
public class Employee {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void work() {
		//logger.info
		System.out.println("*** " + name + " is working");
		//logger.info
	}
	
}
