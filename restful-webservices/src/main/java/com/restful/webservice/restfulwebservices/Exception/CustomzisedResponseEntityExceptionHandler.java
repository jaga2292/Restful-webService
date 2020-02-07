package com.restful.webservice.restfulwebservices.Exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.restful.webservice.restfulwebservices.users.UserNotFoundExpcetion;

@ControllerAdvice
@RestController
public class CustomzisedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	public CustomzisedResponseEntityExceptionHandler() {
		// TODO Auto-generated constructor stub
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> UserhandleAllException(Exception ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(UserNotFoundExpcetion.class)
	public final ResponseEntity<Object> UserNotFoundException(Exception ex, WebRequest request) {
		
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
		
	}
}
