package com.pragma.route.backend.image.infrastructure.db.mapper.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.ImageDtoDataTests;
import com.pragma.route.backend.image.ImageEntityDataTests;
import com.pragma.route.backend.image.infrastructure.db.mongo.mapper.ImageMongoEntityWithDtoMapper;
import com.pragma.route.backend.image.infrastructure.db.mongo.mapper.impl.ImageMongoEntityWithDtoMapperImpl;

@SpringBootTest
public class ImageMongoEntityWithDtoMapperImplTests {
	
	private ImageMongoEntityWithDtoMapper imageMongoEntityWithDtoMapper;
	
	@BeforeEach
	public void setup() {
		imageMongoEntityWithDtoMapper = new ImageMongoEntityWithDtoMapperImpl();
	}

	@Test
	public void toDto() {
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOnlyId)).isEqualTo(ImageDtoDataTests.imageOnlyId);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOKToCreate)).isEqualTo(ImageDtoDataTests.imageOKToCreate);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOKToCreateImageEmpty)).isEqualTo(ImageDtoDataTests.imageOKToCreateImageEmpty);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOKCreated)).isEqualTo(ImageDtoDataTests.imageOKCreated);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOKCreatedImageEmpty)).isEqualTo(ImageDtoDataTests.imageOKCreatedImageEmpty);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOKUpdated)).isEqualTo(ImageDtoDataTests.imageOKUpdated);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOKUpdatedImageEmpty)).isEqualTo(ImageDtoDataTests.imageOKUpdatedImageEmpty);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorCreatedBodyEmpty)).isEqualTo(ImageDtoDataTests.imageErrorCreatedBodyEmpty);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorCreatedIdBodyEmpty)).isEqualTo(ImageDtoDataTests.imageErrorCreatedIdBodyEmpty);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorCreatedIdNotBody)).isEqualTo(ImageDtoDataTests.imageErrorCreatedIdNotBody);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorCreatedIdNotName)).isEqualTo(ImageDtoDataTests.imageErrorCreatedIdNotName);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorCreatedNotBody)).isEqualTo(ImageDtoDataTests.imageErrorCreatedNotBody);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorCreatedNotName)).isEqualTo(ImageDtoDataTests.imageErrorCreatedNotName);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorNewBodyEmpty)).isEqualTo(ImageDtoDataTests.imageErrorNewBodyEmpty);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorNewNotBody)).isEqualTo(ImageDtoDataTests.imageErrorNewNotBody);
		assertThat(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorNewNotName)).isEqualTo(ImageDtoDataTests.imageErrorNewNotName);
	}

	@Test
	public void toMongoEntity() {
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOnlyId)).isEqualTo(ImageEntityDataTests.imageOnlyId);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOKToCreate)).isEqualTo(ImageEntityDataTests.imageOKToCreate);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOKToCreateImageEmpty)).isEqualTo(ImageEntityDataTests.imageOKToCreateImageEmpty);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOKCreated)).isEqualTo(ImageEntityDataTests.imageOKCreated);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOKCreatedImageEmpty)).isEqualTo(ImageEntityDataTests.imageOKCreatedImageEmpty);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOKUpdated)).isEqualTo(ImageEntityDataTests.imageOKUpdated);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOKUpdatedImageEmpty)).isEqualTo(ImageEntityDataTests.imageOKUpdatedImageEmpty);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorCreatedBodyEmpty)).isEqualTo(ImageEntityDataTests.imageErrorCreatedBodyEmpty);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorCreatedIdBodyEmpty)).isEqualTo(ImageEntityDataTests.imageErrorCreatedIdBodyEmpty);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorCreatedIdNotBody)).isEqualTo(ImageEntityDataTests.imageErrorCreatedIdNotBody);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorCreatedIdNotName)).isEqualTo(ImageEntityDataTests.imageErrorCreatedIdNotName);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorCreatedNotBody)).isEqualTo(ImageEntityDataTests.imageErrorCreatedNotBody);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorCreatedNotName)).isEqualTo(ImageEntityDataTests.imageErrorCreatedNotName);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorNewBodyEmpty)).isEqualTo(ImageEntityDataTests.imageErrorNewBodyEmpty);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorNewNotBody)).isEqualTo(ImageEntityDataTests.imageErrorNewNotBody);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorNewNotName)).isEqualTo(ImageEntityDataTests.imageErrorNewNotName);
	}

}
