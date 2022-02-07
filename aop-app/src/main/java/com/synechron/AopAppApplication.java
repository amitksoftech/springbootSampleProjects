package com.synechron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopAppApplication implements CommandLineRunner {

	@Autowired
	private Employee employee;
	
	@Autowired
	private Customer customer;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(employee.getClass().getName());
		System.out.println(customer.getClass().getName());
		employee.setName("Sam");
		employee.work();
		
		customer.setName("Ram");
		customer.buy("iPad");
		customer.buy("iPhone");
	}

	public static void main(String[] args) {
		SpringApplication.run(AopAppApplication.class, args);
	}

}
