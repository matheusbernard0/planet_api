package br.com.cube.swapi.exception;

import org.springframework.http.HttpStatus;

public class PlanetApiException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus;
	private String message;
	
	public PlanetApiException(String message, HttpStatus status) {
		super(message);
		this.httpStatus = status;
		this.message = message;
	}

	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}

	public String getMessage() {
		return message;
	}	
}
