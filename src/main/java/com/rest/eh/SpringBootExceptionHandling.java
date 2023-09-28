package com.rest.eh;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SpringBootExceptionHandling {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> invalidData(MethodArgumentNotValidException exception){
		Map<String, String> errorMap = new HashMap<String, String>();
		exception.getBindingResult().getFieldErrors().forEach(error -> errorMap.put(error.getField(), error.getDefaultMessage()));
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundException.class)
	public Map<String, String> UserException(UserNotFoundException exception){
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("Id Error Message", exception.getMessage());
		return errorMap;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserAgeNotFoundException.class)
	public Map<String, String> UserAgeException(UserAgeNotFoundException exception){
		Map<String, String> errorMap = new HashMap<String, String>();
		errorMap.put("Age Data Error Message", exception.getMessage());
		return errorMap;
	}
}
