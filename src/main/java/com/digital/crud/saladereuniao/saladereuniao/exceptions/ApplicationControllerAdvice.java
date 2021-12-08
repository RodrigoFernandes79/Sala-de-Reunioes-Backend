package com.digital.crud.saladereuniao.saladereuniao.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;


@RestControllerAdvice
public class ApplicationControllerAdvice {
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Map<String,String> HandleValidationException(MethodArgumentNotValidException ex){
		Map<String,String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((err) ->{
			
			String FieldName = ((FieldError) err).getField();
			String ErrorMessage = err.getDefaultMessage();
			
			errors.put(FieldName,ErrorMessage);
			});
		return errors;
	}
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity<ApiStatus> NotFoundValidationException(ResponseStatusException ex){
		String FieldErro = ex.getReason();
		String ErrorMessage = ex.getMessage();
		
		ApiStatus error = new ApiStatus(FieldErro,ErrorMessage);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
}
