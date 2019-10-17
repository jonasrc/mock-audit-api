package com.library.audit.exception;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> internalError(Exception exception){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error. Try again later.");
	}

	@ExceptionHandler({ NoSuchElementException.class })
	public ResponseEntity<Object> notFoundError(Exception exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}
}
