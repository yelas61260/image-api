package com.pragma.route.backend.image.domain.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.ImageDataTests;


@SpringBootTest
public class ModelTests {
	
	@Test
	public void validateImage() {
		Image image = new Image();
		image.setImageId(ImageDataTests.imageOKCreated.getImageId());
		image.setImageName(ImageDataTests.imageOKCreated.getImageName());
		image.setBodyBase64(ImageDataTests.imageOKCreated.getBodyBase64());
		
		Image image2 = new Image(
				ImageDataTests.imageOKCreated.getImageId(), 
				ImageDataTests.imageOKCreated.getImageName(), 
				ImageDataTests.imageOKCreated.getBodyBase64());

		assertTrue(image.equals(ImageDataTests.imageOKCreated));
		assertTrue(image.toString().equals(ImageDataTests.imageOKCreated.toString()));
		assertTrue(image.hashCode() == ImageDataTests.imageOKCreated.hashCode());

		assertTrue(image2.equals(ImageDataTests.imageOKCreated));
		assertTrue(image2.toString().equals(ImageDataTests.imageOKCreated.toString()));
		assertTrue(image2.hashCode() == ImageDataTests.imageOKCreated.hashCode());
		
		assertEquals("Image.ImageBuilder(imageId=null, imageName=null, bodyBase64=null)", Image.builder().toString());
	}

}
