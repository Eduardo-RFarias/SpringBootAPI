package com.example.spring_test.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping
@AllArgsConstructor
public class ApiController {
	@GetMapping("/")
	@ResponseBody
	public List<String> index() {
		return List.of("http://localhost:8080/car/");
	}
}
