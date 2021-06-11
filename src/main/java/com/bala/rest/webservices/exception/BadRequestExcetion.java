package com.bala.rest.webservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestExcetion extends RuntimeException {

	public BadRequestExcetion(String message) {
		super(message);
	}
}
