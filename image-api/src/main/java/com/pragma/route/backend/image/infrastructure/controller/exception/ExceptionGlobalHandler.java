package com.pragma.route.backend.image.infrastructure.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pragma.route.backend.image.domain.exception.conflict.ApiConflictException;
import com.pragma.route.backend.image.domain.exception.notfound.ApiNotFoundException;
import com.pragma.route.backend.image.infrastructure.response.ResponseDTO;

@ControllerAdvice
public class ExceptionGlobalHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ResponseDTO> runtimeException(RuntimeException e) {
		ResponseDTO response = new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), "error", e.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> exception(Exception e) {
		ResponseDTO response = new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), "error", e.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ApiNotFoundException.class)
	public ResponseEntity<ResponseDTO> notFoundException(ApiNotFoundException e){
		ResponseDTO response = new ResponseDTO(HttpStatus.NOT_FOUND.value(), "error", e.getLocalizedMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ApiConflictException.class)
	public ResponseEntity<ResponseDTO> conflictException(ApiConflictException e){
		ResponseDTO response = new ResponseDTO(HttpStatus.CONFLICT.value(), "error", e.getLocalizedMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.CONFLICT);
	}
}
