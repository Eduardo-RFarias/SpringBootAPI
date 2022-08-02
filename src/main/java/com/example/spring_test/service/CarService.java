package com.example.spring_test.service;

import org.springframework.stereotype.Service;

import com.example.spring_test.dto.CarDTO;
import com.example.spring_test.exception.CarNotFoundException;
import com.example.spring_test.model.Car;
import com.example.spring_test.repository.CarRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarService {
	private final CarRepository carRepository;

	public Car retrieveCar(String carModelName) throws CarNotFoundException {
		return carRepository.findById(carModelName).orElseThrow((() -> new CarNotFoundException(carModelName)));
	}

	public Car createNewCar(CarDTO carDTO) {
		Car newCar = new Car();

		newCar.setModelName(carDTO.getModelName());
		newCar.setModelYear(carDTO.getModelYear());

		return carRepository.save(newCar);
	}

	public Iterable<Car> listAllCars() {
		return carRepository.findAll();
	}

	public Car updateCar(String carModelName, CarDTO carDTO) throws CarNotFoundException {
		Car car = retrieveCar(carModelName);

		if (carDTO.getModelName() != null) {
			car.setModelName(carDTO.getModelName());
		}

		if (carDTO.getModelYear() != null) {
			car.setModelYear(carDTO.getModelYear());
		}

		return carRepository.save(car);
	}

	public void deleteCar(String carModelName) throws CarNotFoundException {
		Car car = retrieveCar(carModelName);

		carRepository.delete(car);
	}

	public void deleteAllCars() {
		carRepository.deleteAll();
	}
}
