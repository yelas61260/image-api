package com.pragma.route.backend.image.application.dto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.ImageDtoDataTests;


@SpringBootTest
public class DtoTests {
	
	@Test
	public void validateImage() {
		ImageDto image = new ImageDto();
		image.setImageId(ImageDtoDataTests.imageOKCreated.getImageId());
		image.setImageName(ImageDtoDataTests.imageOKCreated.getImageName());
		image.setImageBase64(ImageDtoDataTests.imageOKCreated.getImageBase64());
		
		ImageDto image2 = new ImageDto(
				ImageDtoDataTests.imageOKCreated.getImageId(), 
				ImageDtoDataTests.imageOKCreated.getImageName(), 
				ImageDtoDataTests.imageOKCreated.getImageBase64());

		assertTrue(image.equals(ImageDtoDataTests.imageOKCreated));
		assertTrue(image.toString().equals(ImageDtoDataTests.imageOKCreated.toString()));
		assertTrue(image.hashCode() == ImageDtoDataTests.imageOKCreated.hashCode());

		assertTrue(image2.equals(ImageDtoDataTests.imageOKCreated));
		assertTrue(image2.toString().equals(ImageDtoDataTests.imageOKCreated.toString()));
		assertTrue(image2.hashCode() == ImageDtoDataTests.imageOKCreated.hashCode());
	}

}
