package com.sumit.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Controller
public class CustomisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		
		ResponseException responseException = new ResponseException(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(responseException,HttpStatus.INTERNAL_SERVER_ERROR);
	
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFound(UserNotFoundException ex, WebRequest request) throws Exception {
		
		ResponseException responseException = new ResponseException(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<Object>(responseException,HttpStatus.NOT_FOUND);
	
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ResponseException responseException = new ResponseException(new Date(),ex.getMessage(),ex.getBindingResult().toString());
		return new ResponseEntity<Object>(responseException,HttpStatus.BAD_REQUEST);
	}

	
	
	
	

}
