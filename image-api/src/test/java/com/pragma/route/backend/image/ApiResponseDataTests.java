package com.pragma.route.backend.image;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pragma.route.backend.image.application.dto.ImageDto;
import com.pragma.route.backend.image.infrastructure.response.ResponseDTO;

@SpringBootTest
public class ApiResponseDataTests {

	public static ResponseDTO error404 = new ResponseDTO(HttpStatus.NOT_FOUND.value(), "error", "mensaje");
	public static ResponseDTO error409 = new ResponseDTO(HttpStatus.CONFLICT.value(), "error", "mensaje");
	public static ResponseDTO error500 = new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR.value(), "error", "mensaje");
	
	public static ResponseEntity<ImageDto> response200Created = new ResponseEntity<ImageDto>(ImageDtoDataTests.imageOKCreated, HttpStatus.OK);
	public static ResponseEntity<ImageDto> response200Updated = new ResponseEntity<ImageDto>(ImageDtoDataTests.imageOKUpdated, HttpStatus.OK);
	public static ResponseEntity<ResponseDTO> response404 = new ResponseEntity<ResponseDTO>(error404, HttpStatus.NOT_FOUND);
	public static ResponseEntity<ResponseDTO> response409 = new ResponseEntity<ResponseDTO>(error409, HttpStatus.CONFLICT);
	public static ResponseEntity<ResponseDTO> response500 = new ResponseEntity<ResponseDTO>(error500, HttpStatus.INTERNAL_SERVER_ERROR);

}
