package com.pragma.route.backend.image.application.mapper.impl;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.application.dto.ImageDTO;
import com.pragma.route.backend.image.application.mapper.ImageWithDtoMapper;
import com.pragma.route.backend.image.application.mapper.impl.ImageWithDtoMapperImpl;
import com.pragma.route.backend.image.domain.model.Image;

@SpringBootTest
public class ImageWithDtoMapperImplTests {
	
	private ImageWithDtoMapper imageWithDtoMapper;
	
	private Image imageOk;
	private ImageDTO imageDtoOk;
	private Image imageError;
	private ImageDTO imageDtoError;
	
	@BeforeEach
	public void setup() {
		imageWithDtoMapper = new ImageWithDtoMapperImpl();
		
		imageOk = Image.builder()
				.associationType(1)
				.resourceId(1)
				.bodyBase64("Content")
				.imageName("imagen")
				.build();
		
		imageDtoOk = ImageDTO.builder()
				.associationType(1)
				.resourceId(1)
				.imageBase64("Content")
				.imageName("imagen")
				.build();
		
		imageError = Image.builder()
				.associationType(1)
				.resourceId(2)
				.bodyBase64("Content2")
				.imageName("imagen2")
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
		assertThat(imageWithDtoMapper.toDto(imageOk)).isEqualTo(imageDtoOk);
		assertThat(imageWithDtoMapper.toDto(imageError)).isNotEqualTo(imageDtoOk);
	}

	@Test
	public void toEntity() {
		assertThat(imageWithDtoMapper.toEntity(imageDtoOk)).isEqualTo(imageOk);
		assertThat(imageWithDtoMapper.toEntity(imageDtoError)).isNotEqualTo(imageOk);
	}

}
