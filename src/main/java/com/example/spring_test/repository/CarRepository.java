package com.example.spring_test.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.spring_test.model.Car;

public interface CarRepository extends CrudRepository<Car, String> {

}
