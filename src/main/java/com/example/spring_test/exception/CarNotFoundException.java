package com.example.spring_test.exception;

public class CarNotFoundException extends Exception {
	public CarNotFoundException(String modelName) {
		super("Could not find a car with the given model name: " + modelName);
	}
}
