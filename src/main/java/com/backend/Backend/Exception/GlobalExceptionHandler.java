package com.backend.Backend.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> handleIdNotFound(IdNotFoundException exp){
		return new ResponseEntity<String>(exp.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(NoRecordFoundException.class)
	public ResponseEntity<String> handleRecordNotFound(NoRecordFoundException exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MissingInformation.class)
	public ResponseEntity<String> handleMissingInformation(MissingInformation exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(RecordAlreadyExistsException.class)
	public ResponseEntity<String> handleRecordAlreadyExixtsException(RecordAlreadyExistsException exp){
		return new ResponseEntity<String> (exp.getMessage(),HttpStatus.NOT_FOUND);
	}
	//
}

