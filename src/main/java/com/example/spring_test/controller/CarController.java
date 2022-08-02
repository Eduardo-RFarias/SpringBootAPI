package com.example.spring_test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring_test.dto.CarDTO;
import com.example.spring_test.exception.CarNotFoundException;
import com.example.spring_test.model.Car;
import com.example.spring_test.service.CarService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/car")
@AllArgsConstructor
public class CarController {
	private final CarService carService;

	@GetMapping
	@ResponseBody
	public Iterable<Car> listAllCars() {
		return carService.listAllCars();
	}

	@PostMapping
	@ResponseBody
	public Car createNewCar(@RequestBody CarDTO carDTO) {
		return carService.createNewCar(carDTO);
	}

	@GetMapping("/{carModelName}")
	@ResponseBody
	public Car retrieveCar(@PathVariable String carModelName) throws CarNotFoundException {
		return carService.retrieveCar(carModelName);
	}
}
