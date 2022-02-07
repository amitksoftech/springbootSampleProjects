package com.synechron;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day02JpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Day02JpaApplication.class, args);
	}

	@Autowired
	private CarRepository carRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		saveCar();
		updateYearOfMake();
		getCars();
		
	}

	private void getCars() {
		List<Car> cars = (List<Car>)carRepository.findAll();
		cars.forEach(System.out::println);
	}

	private void updateYearOfMake() {
		Optional<Car> optCar = carRepository.findById(1);
		if(optCar.isPresent()) {
			Car car = optCar.get();
			car.setYear(2021);
			carRepository.save(car);
		}
	}

	private void saveCar() {
		Car car = new Car("Mini Cooper", 2020);
		carRepository.save(car);
	}

	
}
