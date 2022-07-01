package com.pragma.route.backend.image.infrastructure.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pragma.route.backend.image.domain.exception.conflict.ImageManagerConflictException;
import com.pragma.route.backend.image.domain.exception.notfound.ImageManagerNotFoundException;
import com.pragma.route.backend.image.infrastructure.response.ResponseDTO;

@ControllerAdvice
public class ExceptionGlobalHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ResponseDTO> runtimeException(RuntimeException e) {
		ResponseDTO response = new ResponseDTO(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "error", e.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseDTO> exception(Exception e) {
		ResponseDTO response = new ResponseDTO(null, HttpStatus.INTERNAL_SERVER_ERROR.value(), "error", e.getMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ImageManagerNotFoundException.class)
	public ResponseEntity<ResponseDTO> notFoundException(ImageManagerNotFoundException e){
		ResponseDTO response = new ResponseDTO(null, HttpStatus.NOT_FOUND.value(), "error", e.getLocalizedMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ImageManagerConflictException.class)
	public ResponseEntity<ResponseDTO> conflictException(ImageManagerConflictException e){
		ResponseDTO response = new ResponseDTO(null, HttpStatus.CONFLICT.value(), "error", e.getLocalizedMessage());
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.CONFLICT);
	}
}
