package com.pragma.route.backend.image;

import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.application.dto.ImageDto;

public class ImageDtoDataTests {

	public static ImageDto imageOnlyId = ImageDto.builder()
			.imageId("PrueBa123C")
			.build();
	public static ImageDto imageOnlyIdEmpty = ImageDto.builder()
			.imageId("")
			.build();
	public static ImageDto imageOnlyIdNull = ImageDto.builder()
			.build();
	public static ImageDto imageOKToCreateImageEmpty = ImageDto.builder()
			.imageId(null)
			.imageName("mi imagen")
			.build();
	public static ImageDto imageOKToCreate = ImageDto.builder()
			.imageId(null)
			.imageName("mi imagen")
			.imageBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static ImageDto imageOKCreated = ImageDto.builder()
			.imageId("PrueBa123C")
			.imageName("mi imagen")
			.imageBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static ImageDto imageOKCreatedImageEmpty = ImageDto.builder()
			.imageId("PrueBa123C")
			.imageName("mi imagen")
			.build();
	public static ImageDto imageOKUpdated = ImageDto.builder()
			.imageId("PrueBa123U")
			.imageName("mi imagen")
			.imageBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static ImageDto imageOKUpdatedImageEmpty = ImageDto.builder()
			.imageId("PrueBa123U")
			.imageName("mi imagen")
			.build();
	
	public static ImageDto imageErrorNewNotName = ImageDto.builder()
			.imageBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static ImageDto imageErrorNewNotBody = ImageDto.builder()
			.imageName("mi imagen")
			.build();
	public static ImageDto imageErrorNewBodyEmpty = ImageDto.builder()
			.imageName("mi imagen")
			.imageBase64(ImageFileDataTests.stringBaseErrorEmpty)
			.build();
	
	
	public static ImageDto imageErrorCreatedIdNotName = ImageDto.builder()
			.imageId("PrueBa1231")
			.build();
	public static ImageDto imageErrorCreatedIdNotBody = ImageDto.builder()
			.imageId("PrueBa1232")
			.build();
	public static ImageDto imageErrorCreatedIdBodyEmpty = ImageDto.builder()
			.imageId("PrueBa1233")
			.build();
	
	public static ImageDto imageErrorCreatedNotName = ImageDto.builder()
			.imageId("PrueBa1231")
			.imageBase64(ImageFileDataTests.stringBaseOk)
			.build();
	public static ImageDto imageErrorCreatedNotBody = ImageDto.builder()
			.imageId("PrueBa1232")
			.imageName("mi imagen")
			.build();
	public static ImageDto imageErrorCreatedBodyEmpty = ImageDto.builder()
			.imageId("PrueBa1233")
			.imageName("mi imagen")
			.imageBase64(ImageFileDataTests.stringBaseErrorEmpty)
			.build();

}
