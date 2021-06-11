package com.bala.rest.webservices.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
		ErrorMessage message = new ErrorMessage(500, ex.getMessage());
		return new ResponseEntity(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex) {
		ErrorMessage message = new ErrorMessage(404, ex.getMessage());
		return new ResponseEntity(message, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BadRequestExcetion.class)
	public final ResponseEntity<Object> handleBadRequestExcetion(Exception ex) {
		ErrorMessage message = new ErrorMessage(400, ex.getMessage());
		return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorMessage message = new ErrorMessage(400, "Birth Date should be past");
		return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
	}
}
