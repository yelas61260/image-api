package com.pragma.route.backend.image.infrastructure.db.repository.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.application.dto.ImageDTO;
import com.pragma.route.backend.image.infrastructure.db.dao.ImageDao;
import com.pragma.route.backend.image.infrastructure.db.entity.ImageMongoEntity;
import com.pragma.route.backend.image.infrastructure.db.mapper.ImageMongoEntityWithDtoMapper;
import com.pragma.route.backend.image.infrastructure.db.repository.ImageRepository;

@SpringBootTest
public class ImageRepositoryTests {
	
	@Mock
	private ImageDao imageDao;
	
	@Mock
	private ImageMongoEntityWithDtoMapper imageMongoEntityWithDtoMapper;
	
	private ImageRepository imageRepository;
	
	@BeforeEach
	public void setup() {
		imageRepository = new ImageRepositoryImpl(imageDao, imageMongoEntityWithDtoMapper);
		
		ImageMongoEntity imageEntity1 = ImageMongoEntity.builder()
				.id("PI-1")
				.bodyBase64("content")
				.imageName("image")
				.build();
		ImageDTO imageDTO1 = ImageDTO.builder()
				.associationType(1)
				.resourceId(1)
				.imageBase64("content")
				.imageName("image")
				.build();
		ImageMongoEntity imageEntity2 = ImageMongoEntity.builder()
				.id("PI-1")
				.build();
		ImageDTO imageDTO2 = ImageDTO.builder()
				.associationType(1)
				.resourceId(1)
				.build();
		ImageMongoEntity imageEntityError = ImageMongoEntity.builder()
				.id("PI-0")
				.build();
		ImageDTO imageDTOError = ImageDTO.builder()
				.associationType(1)
				.resourceId(0)
				.build();
		
		Mockito.when(imageDao.findById("PI-0"))
		.thenReturn(Optional.empty());
		Mockito.when(imageDao.findById("PI-1"))
		.thenReturn(Optional.of(imageEntity1));
		Mockito.when(imageDao.insert(imageEntity1))
		.thenReturn(imageEntity1);
		Mockito.when(imageDao.save(imageEntity1))
		.thenReturn(imageEntity1);
		
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(imageEntity1))
		.thenReturn(imageDTO1);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(imageDTO1))
		.thenReturn(imageEntity1);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(imageEntity2))
		.thenReturn(imageDTO2);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(imageDTO2))
		.thenReturn(imageEntity2);
		

		Mockito.when(imageMongoEntityWithDtoMapper.toDto(imageEntityError))
		.thenReturn(imageDTOError);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(imageDTOError))
		.thenReturn(imageEntityError);
	}
	
	@Test
	public void getById() {
		ImageDTO imageDTO1 = ImageDTO.builder()
				.associationType(1)
				.resourceId(0)
				.build();
		ImageDTO imageDTOResponse1 = imageRepository.getById(imageDTO1);
		assertNull(imageDTOResponse1);

		ImageDTO imageDTO2 = ImageDTO.builder()
				.associationType(1)
				.resourceId(1)
				.build();
		ImageDTO imageDTOResponse2 = imageRepository.getById(imageDTO2);
		assertThat(imageDTOResponse2.getAssociationType()).isEqualTo(1);
		assertThat(imageDTOResponse2.getResourceId()).isEqualTo(1);
		assertThat(imageDTOResponse2.getImageBase64()).isEqualTo("content");
	}
	
	@Test
	public void create() {
		ImageDTO imageDTO = ImageDTO.builder()
				.associationType(1)
				.resourceId(1)
				.imageBase64("content")
				.imageName("image")
				.build();
		ImageDTO imageDTOResponse = imageRepository.create(imageDTO);
		assertThat(imageDTOResponse.getAssociationType()).isEqualTo(1);
		assertThat(imageDTOResponse.getResourceId()).isEqualTo(1);
	}
	
	@Test
	public void update() {
		ImageDTO imageDTO = ImageDTO.builder()
				.associationType(1)
				.resourceId(1)
				.imageBase64("content")
				.imageName("image")
				.build();
		ImageDTO imageDTOResponse = imageRepository.update(imageDTO);
		assertThat(imageDTOResponse.getAssociationType()).isEqualTo(1);
		assertThat(imageDTOResponse.getResourceId()).isEqualTo(1);
	}

}
