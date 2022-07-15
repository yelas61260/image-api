package com.pragma.route.backend.image;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pragma.route.backend.image.application.dto.ImageDto;
import com.pragma.route.backend.image.infrastructure.response.ResponseDTO;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

	@Test
	public void validateResponse(){
		ResponseDTO responseDTO1 = new ResponseDTO(
				error404.getRespondeCode(),
				error404.getStatus(),
				error404.getDescription());

		ResponseDTO responseDTO2 = new ResponseDTO(
				0,
				error404.getStatus(),
				error404.getDescription());

		ResponseDTO responseDTO3 = new ResponseDTO(
				error404.getRespondeCode(),
				"",
				error404.getDescription());

		ResponseDTO responseDTO4 = new ResponseDTO(
				error404.getRespondeCode(),
				error404.getStatus(),
				"");

		assertNotEquals(error404, responseDTO1);
		assertNotEquals(error404, responseDTO2);
		assertNotEquals(error404, responseDTO3);
		assertNotEquals(error404, responseDTO4);
		assertNotEquals(error404, new Object());
		assertNotEquals(error404.hashCode(), responseDTO1.hashCode());
		assertNotEquals(error404.hashCode(), responseDTO2.hashCode());
		assertNotEquals(error404.hashCode(), responseDTO3.hashCode());
		assertNotEquals(error404.hashCode(), responseDTO4.hashCode());
		assertNotEquals(error404.hashCode(), new Object().hashCode());
		assertTrue(error404.canEqual(responseDTO1));
		assertTrue(error404.canEqual(responseDTO2));
		assertTrue(error404.canEqual(responseDTO3));
		assertTrue(error404.canEqual(responseDTO4));
		assertEquals(error404, ApiResponseDataTests.error404);

		assertEquals(error404.getRespondeCode(), responseDTO1.getRespondeCode());
		assertEquals(error404.getStatus(), responseDTO1.getStatus());
		assertEquals(error404.getDescription(), responseDTO1.getDescription());
	}

}
