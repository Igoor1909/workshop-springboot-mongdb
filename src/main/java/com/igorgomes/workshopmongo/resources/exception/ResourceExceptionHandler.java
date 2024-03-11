package com.igorgomes.workshopmongo.resources.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.igorgomes.workshopmongo.services.exception.ObjectoNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectoNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectoNotFoundException e, HttpServletRequest request){
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err =  new StandardError(System.currentTimeMillis(),status.value() ,"Não encontrado" ,e.getMessage() , request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
