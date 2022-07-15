package com.pragma.route.backend.image.infrastructure.db.repository.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.ImageDtoDataTests;
import com.pragma.route.backend.image.ImageEntityDataTests;
import com.pragma.route.backend.image.infrastructure.db.mongo.mapper.ImageMongoEntityWithDtoMapper;
import com.pragma.route.backend.image.infrastructure.db.mongo.normal.dao.ImageDao;
import com.pragma.route.backend.image.infrastructure.db.mongo.normal.repository.ImageRepository;
import com.pragma.route.backend.image.infrastructure.db.mongo.normal.repository.impl.ImageRepositoryImpl;

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
		
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOnlyId)).thenReturn(ImageDtoDataTests.imageOnlyId);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(null)).thenReturn(null);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOKToCreate)).thenReturn(ImageDtoDataTests.imageOKToCreate);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOKToCreateImageEmpty)).thenReturn(ImageDtoDataTests.imageOKToCreateImageEmpty);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOKCreated)).thenReturn(ImageDtoDataTests.imageOKCreated);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOKCreatedImageEmpty)).thenReturn(ImageDtoDataTests.imageOKCreatedImageEmpty);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOKUpdated)).thenReturn(ImageDtoDataTests.imageOKUpdated);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageOKUpdatedImageEmpty)).thenReturn(ImageDtoDataTests.imageOKUpdatedImageEmpty);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorCreatedBodyEmpty)).thenReturn(ImageDtoDataTests.imageErrorCreatedBodyEmpty);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorCreatedIdBodyEmpty)).thenReturn(ImageDtoDataTests.imageErrorCreatedIdBodyEmpty);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorCreatedIdNotBody)).thenReturn(ImageDtoDataTests.imageErrorCreatedIdNotBody);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorCreatedIdNotName)).thenReturn(ImageDtoDataTests.imageErrorCreatedIdNotName);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorCreatedNotBody)).thenReturn(ImageDtoDataTests.imageErrorCreatedNotBody);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorCreatedNotName)).thenReturn(ImageDtoDataTests.imageErrorCreatedNotName);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorNewBodyEmpty)).thenReturn(ImageDtoDataTests.imageErrorNewBodyEmpty);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorNewNotBody)).thenReturn(ImageDtoDataTests.imageErrorNewNotBody);
		Mockito.when(imageMongoEntityWithDtoMapper.toDto(ImageEntityDataTests.imageErrorNewNotName)).thenReturn(ImageDtoDataTests.imageErrorNewNotName);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOnlyId)).thenReturn(ImageEntityDataTests.imageOnlyId);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOnlyIdEmpty)).thenReturn(ImageEntityDataTests.imageOnlyIdEmpty);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOKToCreate)).thenReturn(ImageEntityDataTests.imageOKToCreate);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOKToCreateImageEmpty)).thenReturn(ImageEntityDataTests.imageOKToCreateImageEmpty);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOKCreated)).thenReturn(ImageEntityDataTests.imageOKCreated);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOKCreatedImageEmpty)).thenReturn(ImageEntityDataTests.imageOKCreatedImageEmpty);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOKUpdated)).thenReturn(ImageEntityDataTests.imageOKUpdated);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageOKUpdatedImageEmpty)).thenReturn(ImageEntityDataTests.imageOKUpdatedImageEmpty);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorCreatedBodyEmpty)).thenReturn(ImageEntityDataTests.imageErrorCreatedBodyEmpty);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorCreatedIdBodyEmpty)).thenReturn(ImageEntityDataTests.imageErrorCreatedIdBodyEmpty);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorCreatedIdNotBody)).thenReturn(ImageEntityDataTests.imageErrorCreatedIdNotBody);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorCreatedIdNotName)).thenReturn(ImageEntityDataTests.imageErrorCreatedIdNotName);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorCreatedNotBody)).thenReturn(ImageEntityDataTests.imageErrorCreatedNotBody);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorCreatedNotName)).thenReturn(ImageEntityDataTests.imageErrorCreatedNotName);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorNewBodyEmpty)).thenReturn(ImageEntityDataTests.imageErrorNewBodyEmpty);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorNewNotBody)).thenReturn(ImageEntityDataTests.imageErrorNewNotBody);
		Mockito.when(imageMongoEntityWithDtoMapper.toMongoEntity(ImageDtoDataTests.imageErrorNewNotName)).thenReturn(ImageEntityDataTests.imageErrorNewNotName);

		Mockito.when(imageDao.findById(ImageEntityDataTests.imageOnlyId.getId())).thenReturn(Optional.of(ImageEntityDataTests.imageOKCreated));
		Mockito.when(imageDao.findById(ImageEntityDataTests.imageOKCreated.getId())).thenReturn(Optional.of(ImageEntityDataTests.imageOKCreated));
		Mockito.when(imageDao.findById("")).thenReturn(Optional.empty());
		Mockito.when(imageDao.findById(null)).thenReturn(Optional.empty());
		Mockito.when(imageDao.insert(ImageEntityDataTests.imageOKToCreate)).thenReturn(ImageEntityDataTests.imageOKCreated);
		Mockito.when(imageDao.save(ImageEntityDataTests.imageOKCreated)).thenReturn(ImageEntityDataTests.imageOKCreated);
		Mockito.when(imageDao.save(ImageEntityDataTests.imageOKUpdated)).thenReturn(ImageEntityDataTests.imageOKUpdated);
	}
	
	@Test
	public void getById() {
		assertNull(imageRepository.getById(ImageDtoDataTests.imageOnlyIdEmpty.getImageId()));
		assertNull(imageRepository.getById(ImageDtoDataTests.imageOKToCreate.getImageId()));
		assertThat(imageRepository.getById(ImageDtoDataTests.imageOnlyId.getImageId())).isEqualTo(ImageDtoDataTests.imageOKCreated);
	}
	
	@Test
	public void create() {
		assertThat(imageRepository.create(ImageDtoDataTests.imageOKToCreate)).isEqualTo(ImageDtoDataTests.imageOKCreated);
	}
	
	@Test
	public void update() {
		assertThat(imageRepository.update(ImageDtoDataTests.imageOKCreated)).isEqualTo(ImageDtoDataTests.imageOKCreated);
		assertThat(imageRepository.update(ImageDtoDataTests.imageOKUpdated)).isEqualTo(ImageDtoDataTests.imageOKUpdated);
	}

}
