package br.com.cube.swapi.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class PlanetApiExceptionHandler extends ResponseEntityExceptionHandler{	
	
	@ExceptionHandler(PlanetApiException.class)
	public ResponseEntity<ErrorDetails> handlePlanetApiException(PlanetApiException planetApiException, WebRequest request){
		ErrorDetails details = new ErrorDetails(new Date(), planetApiException.getMessage());
		return new ResponseEntity<>(details, planetApiException.getHttpStatus());
	}
	
	@Override
	protected ResponseEntity<Object> handleBindException(BindException bindException, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		ErrorDetails details = new ErrorDetails(new Date(), bindException.getMessage());
		return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		 List<ObjectError> errors = methodArgumentNotValidException.getBindingResult().getAllErrors();
		 
		 List<String> list = new ArrayList<>();
		 
		 if (!errors.isEmpty()) {
			 errors.forEach( err -> {
				 list.add(err.getDefaultMessage());
			 });
		 }		 		 
		
		return new ResponseEntity<>(new ErrorDetails(new Date(), list), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleGenericException(Exception exception, WebRequest request){
		ErrorDetails details = new ErrorDetails(new Date(), exception.getMessage());
		return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
