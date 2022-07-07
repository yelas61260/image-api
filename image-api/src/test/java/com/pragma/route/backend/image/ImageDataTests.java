package com.pragma.route.backend.image;

import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.domain.model.Image;

@SpringBootTest
public class ImageDataTests {

	public static Image imageOnlyId = Image.builder()
			.imageId("PrueBa123C")
			.build();
	public static Image imageOnlyIdEmpty = Image.builder()
			.imageId("")
			.build();
	public static Image imageOnlyIdNull = Image.builder()
			.build();
	public static Image imageOKToCreateImageEmpty = Image.builder()
			.imageId(null)
			.imageName("mi imagen")
			.build();
	public static Image imageOKToCreate = Image.builder()
			.imageId(null)
			.imageName("mi imagen")
			.bodyBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static Image imageOKCreated = Image.builder()
			.imageId("PrueBa123C")
			.imageName("mi imagen")
			.bodyBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static Image imageOKCreatedImageEmpty = Image.builder()
			.imageId("PrueBa123C")
			.imageName("mi imagen")
			.build();
	public static Image imageOKUpdated = Image.builder()
			.imageId("PrueBa123U")
			.imageName("mi imagen")
			.bodyBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static Image imageOKUpdatedImageEmpty = Image.builder()
			.imageId("PrueBa123U")
			.imageName("mi imagen")
			.build();
	
	public static Image imageErrorNewNotName = Image.builder()
			.bodyBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static Image imageErrorNewNotBody = Image.builder()
			.imageName("mi imagen")
			.build();
	public static Image imageErrorNewBodyEmpty = Image.builder()
			.imageName("mi imagen")
			.bodyBase64(ImageFileDataTests.stringBaseErrorEmpty)
			.build();
	
	
	public static Image imageErrorCreatedIdNotName = Image.builder()
			.imageId("PrueBa1231")
			.build();
	public static Image imageErrorCreatedIdNotBody = Image.builder()
			.imageId("PrueBa1232")
			.build();
	public static Image imageErrorCreatedIdBodyEmpty = Image.builder()
			.imageId("PrueBa1233")
			.build();
	
	public static Image imageErrorCreatedNotName = Image.builder()
			.imageId("PrueBa1231")
			.bodyBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static Image imageErrorCreatedNotBody = Image.builder()
			.imageId("PrueBa1232")
			.imageName("mi imagen")
			.build();
	public static Image imageErrorCreatedBodyEmpty = Image.builder()
			.imageId("PrueBa1233")
			.imageName("mi imagen")
			.bodyBase64(ImageFileDataTests.stringBaseErrorEmpty)
			.build();

}
