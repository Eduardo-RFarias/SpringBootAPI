package com.example.spring_test.advice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.spring_test.exception.CarNotFoundException;

@ControllerAdvice
public class CarControllerAdvice extends ResponseEntityExceptionHandler {

	@ResponseBody
	@ExceptionHandler(CarNotFoundException.class)
	@ResponseStatus(code = NOT_FOUND)
	public String handleCarNotFoundException(HttpServletRequest request, Throwable ex) {
		return ex.getMessage();
	}

}
