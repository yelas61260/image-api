package com.pragma.route.backend.image;

import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.infrastructure.db.entity.ImageMongoEntity;

public class ImageEntityDataTests {

	public static ImageMongoEntity imageOnlyId = ImageMongoEntity.builder()
			.id("PrueBa123C")
			.build();
	public static ImageMongoEntity imageOnlyIdEmpty = ImageMongoEntity.builder()
			.id("")
			.build();
	public static ImageMongoEntity imageOnlyIdNull = ImageMongoEntity.builder()
			.build();
	public static ImageMongoEntity imageOKToCreateImageEmpty = ImageMongoEntity.builder()
			.id(null)
			.imageName("mi imagen")
			.build();
	public static ImageMongoEntity imageOKToCreate = ImageMongoEntity.builder()
			.id(null)
			.imageName("mi imagen")
			.bodyBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static ImageMongoEntity imageOKCreated = ImageMongoEntity.builder()
			.id("PrueBa123C")
			.imageName("mi imagen")
			.bodyBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static ImageMongoEntity imageOKCreatedImageEmpty = ImageMongoEntity.builder()
			.id("PrueBa123C")
			.imageName("mi imagen")
			.build();
	public static ImageMongoEntity imageOKUpdated = ImageMongoEntity.builder()
			.id("PrueBa123U")
			.imageName("mi imagen")
			.bodyBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static ImageMongoEntity imageOKUpdatedImageEmpty = ImageMongoEntity.builder()
			.id("PrueBa123U")
			.imageName("mi imagen")
			.build();
	
	public static ImageMongoEntity imageErrorNewNotName = ImageMongoEntity.builder()
			.bodyBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static ImageMongoEntity imageErrorNewNotBody = ImageMongoEntity.builder()
			.imageName("mi imagen")
			.build();
	public static ImageMongoEntity imageErrorNewBodyEmpty = ImageMongoEntity.builder()
			.imageName("mi imagen")
			.bodyBase64(ImageFileDataTests.stringBaseErrorEmpty)
			.build();
	
	
	public static ImageMongoEntity imageErrorCreatedIdNotName = ImageMongoEntity.builder()
			.id("PrueBa1231")
			.build();
	public static ImageMongoEntity imageErrorCreatedIdNotBody = ImageMongoEntity.builder()
			.id("PrueBa1232")
			.build();
	public static ImageMongoEntity imageErrorCreatedIdBodyEmpty = ImageMongoEntity.builder()
			.id("PrueBa1233")
			.build();
	
	public static ImageMongoEntity imageErrorCreatedNotName = ImageMongoEntity.builder()
			.id("PrueBa1231")
			.bodyBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static ImageMongoEntity imageErrorCreatedNotBody = ImageMongoEntity.builder()
			.id("PrueBa1232")
			.imageName("mi imagen")
			.build();
	public static ImageMongoEntity imageErrorCreatedBodyEmpty = ImageMongoEntity.builder()
			.id("PrueBa1233")
			.imageName("mi imagen")
			.bodyBase64(ImageFileDataTests.stringBaseErrorEmpty)
			.build();

}
