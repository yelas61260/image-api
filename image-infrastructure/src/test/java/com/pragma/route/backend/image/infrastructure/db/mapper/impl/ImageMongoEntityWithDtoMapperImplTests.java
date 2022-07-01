package com.pragma.route.backend.image.infrastructure.db.mapper.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.application.dto.ImageDTO;
import com.pragma.route.backend.image.infrastructure.db.entity.ImageMongoEntity;
import com.pragma.route.backend.image.infrastructure.db.mapper.ImageMongoEntityWithDtoMapper;

@SpringBootTest
public class ImageMongoEntityWithDtoMapperImplTests {
	
	private ImageMongoEntity imageMongoEntityOk;
	private ImageDTO imageDtoOk;
	private ImageMongoEntity imageMongoEntityError;
	private ImageDTO imageDtoError;
	
	private ImageMongoEntityWithDtoMapper imageMongoEntityWithDtoMapper;
	
	@BeforeEach
	public void setup() {
		imageMongoEntityWithDtoMapper = new ImageMongoEntityWithDtoMapperImpl();

		imageDtoOk = ImageDTO.builder()
				.associationType(1)
				.resourceId(1)
				.imageBase64("Content")
				.imageName("imagen")
				.build();
		
		imageDtoError = ImageDTO.builder()
				.associationType(1)
				.resourceId(2)
				.imageBase64("Content2")
				.imageName("imagen2")
				.build();
	}

	@Test
	public void toDto() {
		assertThat(imageMongoEntityWithDtoMapper.toDto(imageMongoEntityOk)).isEqualTo(imageDtoOk);
		assertThat(imageMongoEntityWithDtoMapper.toDto(imageMongoEntityError)).isNotEqualTo(imageDtoOk);
	}

	@Test
	public void toMongoEntity() {
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(imageDtoOk)).isEqualTo(imageMongoEntityOk);
		assertThat(imageMongoEntityWithDtoMapper.toMongoEntity(imageDtoError)).isNotEqualTo(imageMongoEntityOk);
	}

}
