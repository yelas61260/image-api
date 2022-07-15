package com.pragma.route.backend.image.infrastructure.db.entity;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.ImageEntityDataTests;
import com.pragma.route.backend.image.infrastructure.db.entity.ImageMongoEntity;

@SpringBootTest
public class MongoEntityTests {
	
	@Test
	public void validateImage() {
		ImageMongoEntity image = new ImageMongoEntity();
		image.setId(ImageEntityDataTests.imageOKCreated.getId());
		image.setImageName(ImageEntityDataTests.imageOKCreated.getImageName());
		image.setBodyBase64(ImageEntityDataTests.imageOKCreated.getBodyBase64());
		
		ImageMongoEntity image2 = new ImageMongoEntity(
				ImageEntityDataTests.imageOKCreated.getId(), 
				ImageEntityDataTests.imageOKCreated.getImageName(), 
				ImageEntityDataTests.imageOKCreated.getBodyBase64());

		assertTrue(image.equals(ImageEntityDataTests.imageOKCreated));
		assertTrue(image.toString().equals(ImageEntityDataTests.imageOKCreated.toString()));
		assertTrue(image.hashCode() == ImageEntityDataTests.imageOKCreated.hashCode());

		assertTrue(image2.equals(ImageEntityDataTests.imageOKCreated));
		assertTrue(image2.toString().equals(ImageEntityDataTests.imageOKCreated.toString()));
		assertTrue(image2.hashCode() == ImageEntityDataTests.imageOKCreated.hashCode());
	}

}
