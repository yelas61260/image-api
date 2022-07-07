package com.pragma.route.backend.image.application.mapper.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.ImageDataTests;
import com.pragma.route.backend.image.ImageDtoDataTests;
import com.pragma.route.backend.image.application.mapper.ImageWithDtoMapper;

@SpringBootTest
public class ImageWithDtoMapperImplTests {
	
	private ImageWithDtoMapper imageWithDtoMapper;
	
	@BeforeEach
	public void setup() {
		imageWithDtoMapper = new ImageWithDtoMapperImpl();
	}

	@Test
	public void toDto() {
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageOnlyId)).isEqualTo(ImageDtoDataTests.imageOnlyId);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageOKToCreate)).isEqualTo(ImageDtoDataTests.imageOKToCreate);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageOKToCreateImageEmpty)).isEqualTo(ImageDtoDataTests.imageOKToCreateImageEmpty);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageOKCreated)).isEqualTo(ImageDtoDataTests.imageOKCreated);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageOKCreatedImageEmpty)).isEqualTo(ImageDtoDataTests.imageOKCreatedImageEmpty);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageOKUpdated)).isEqualTo(ImageDtoDataTests.imageOKUpdated);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageOKUpdatedImageEmpty)).isEqualTo(ImageDtoDataTests.imageOKUpdatedImageEmpty);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageErrorCreatedBodyEmpty)).isEqualTo(ImageDtoDataTests.imageErrorCreatedBodyEmpty);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageErrorCreatedIdBodyEmpty)).isEqualTo(ImageDtoDataTests.imageErrorCreatedIdBodyEmpty);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageErrorCreatedIdNotBody)).isEqualTo(ImageDtoDataTests.imageErrorCreatedIdNotBody);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageErrorCreatedIdNotName)).isEqualTo(ImageDtoDataTests.imageErrorCreatedIdNotName);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageErrorCreatedNotBody)).isEqualTo(ImageDtoDataTests.imageErrorCreatedNotBody);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageErrorCreatedNotName)).isEqualTo(ImageDtoDataTests.imageErrorCreatedNotName);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageErrorNewBodyEmpty)).isEqualTo(ImageDtoDataTests.imageErrorNewBodyEmpty);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageErrorNewNotBody)).isEqualTo(ImageDtoDataTests.imageErrorNewNotBody);
		assertThat(imageWithDtoMapper.toDto(ImageDataTests.imageErrorNewNotName)).isEqualTo(ImageDtoDataTests.imageErrorNewNotName);
	}

	@Test
	public void toEntity() {
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOnlyId)).isEqualTo(ImageDataTests.imageOnlyId);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOKToCreate)).isEqualTo(ImageDataTests.imageOKToCreate);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOKToCreateImageEmpty)).isEqualTo(ImageDataTests.imageOKToCreateImageEmpty);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOKCreated)).isEqualTo(ImageDataTests.imageOKCreated);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOKCreatedImageEmpty)).isEqualTo(ImageDataTests.imageOKCreatedImageEmpty);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOKUpdated)).isEqualTo(ImageDataTests.imageOKUpdated);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOKUpdatedImageEmpty)).isEqualTo(ImageDataTests.imageOKUpdatedImageEmpty);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorCreatedBodyEmpty)).isEqualTo(ImageDataTests.imageErrorCreatedBodyEmpty);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorCreatedIdBodyEmpty)).isEqualTo(ImageDataTests.imageErrorCreatedIdBodyEmpty);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorCreatedIdNotBody)).isEqualTo(ImageDataTests.imageErrorCreatedIdNotBody);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorCreatedIdNotName)).isEqualTo(ImageDataTests.imageErrorCreatedIdNotName);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorCreatedNotBody)).isEqualTo(ImageDataTests.imageErrorCreatedNotBody);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorCreatedNotName)).isEqualTo(ImageDataTests.imageErrorCreatedNotName);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorNewBodyEmpty)).isEqualTo(ImageDataTests.imageErrorNewBodyEmpty);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorNewNotBody)).isEqualTo(ImageDataTests.imageErrorNewNotBody);
		assertThat(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorNewNotName)).isEqualTo(ImageDataTests.imageErrorNewNotName);
	}

}
