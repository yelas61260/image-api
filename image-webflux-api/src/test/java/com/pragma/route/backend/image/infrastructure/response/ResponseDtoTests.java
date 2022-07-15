package com.pragma.route.backend.image.infrastructure.response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.ApiResponseDataTests;

@SpringBootTest
public class ResponseDtoTests {
	
	@Test
	public void validateResponseDto() {
		ResponseDTO responseDTO1 = new ResponseDTO(
				ApiResponseDataTests.error404.getRespondeCode(), 
				ApiResponseDataTests.error404.getStatus(), 
				ApiResponseDataTests.error404.getDescription());

		ResponseDTO responseDTO2 = new ResponseDTO(
				0, 
				ApiResponseDataTests.error404.getStatus(), 
				ApiResponseDataTests.error404.getDescription());

		ResponseDTO responseDTO3 = new ResponseDTO(
				ApiResponseDataTests.error404.getRespondeCode(), 
				"", 
				ApiResponseDataTests.error404.getDescription());

		ResponseDTO responseDTO4 = new ResponseDTO(
				ApiResponseDataTests.error404.getRespondeCode(), 
				ApiResponseDataTests.error404.getStatus(), 
				"");
		
		assertNotEquals(ApiResponseDataTests.error404, responseDTO1);
		assertNotEquals(ApiResponseDataTests.error404, responseDTO2);
		assertNotEquals(ApiResponseDataTests.error404, responseDTO3);
		assertNotEquals(ApiResponseDataTests.error404, responseDTO4);
		assertNotEquals(ApiResponseDataTests.error404, new Object());
		assertNotEquals(ApiResponseDataTests.error404.hashCode(), responseDTO1.hashCode());
		assertNotEquals(ApiResponseDataTests.error404.hashCode(), responseDTO2.hashCode());
		assertNotEquals(ApiResponseDataTests.error404.hashCode(), responseDTO3.hashCode());
		assertNotEquals(ApiResponseDataTests.error404.hashCode(), responseDTO4.hashCode());
		assertNotEquals(ApiResponseDataTests.error404.hashCode(), new Object().hashCode());
		assertTrue(ApiResponseDataTests.error404.canEqual(responseDTO1));
		assertTrue(ApiResponseDataTests.error404.canEqual(responseDTO2));
		assertTrue(ApiResponseDataTests.error404.canEqual(responseDTO3));
		assertTrue(ApiResponseDataTests.error404.canEqual(responseDTO4));
		assertEquals(ApiResponseDataTests.error404, ApiResponseDataTests.error404);
		
		assertEquals(ApiResponseDataTests.error404.getRespondeCode(), responseDTO1.getRespondeCode());
		assertEquals(ApiResponseDataTests.error404.getStatus(), responseDTO1.getStatus());
		assertEquals(ApiResponseDataTests.error404.getDescription(), responseDTO1.getDescription());
	}

}
