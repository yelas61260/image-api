package com.pragma.route.backend.image.application.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.ImageDataTests;
import com.pragma.route.backend.image.ImageDtoDataTests;
import com.pragma.route.backend.image.ImageFileDataTests;
import com.pragma.route.backend.image.application.mapper.ImageWithDtoMapper;
import com.pragma.route.backend.image.application.service.ImageService;
import com.pragma.route.backend.image.domain.exception.conflict.ImageConvertException;
import com.pragma.route.backend.image.domain.exception.conflict.ImageIdRequiredException;
import com.pragma.route.backend.image.domain.service.ImageDomainService;

@SpringBootTest
public class ImageServiceImplTests {
	
	private ImageService imageService;
	
	@Mock
	private ImageDomainService imageDomainService;
	
	@Mock
	private ImageWithDtoMapper imageWithDtoMapper;
	
	@BeforeEach
	public void setup() {
		imageService = new ImageServiceImpl(imageDomainService, imageWithDtoMapper);		

		Mockito.when(imageDomainService.prepareToCreate(ImageDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteOk)).thenReturn(ImageDataTests.imageOKToCreate);
		Mockito.when(imageDomainService.prepareToCreate(ImageDataTests.imageOKToCreate, ImageFileDataTests.stringByteOk)).thenReturn(ImageDataTests.imageOKToCreate);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).prepareToCreate(ImageDataTests.imageErrorNewNotName, ImageFileDataTests.stringByteOk);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).prepareToCreate(ImageDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).prepareToCreate(ImageDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteErrorNull);
		Mockito.when(imageDomainService.prepareToUpdate(ImageDataTests.imageOKUpdated, ImageFileDataTests.stringByteOk)).thenReturn(ImageDataTests.imageOKUpdated);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).prepareToUpdate(ImageDataTests.imageOKUpdated, ImageFileDataTests.stringByteErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).prepareToUpdate(ImageDataTests.imageOKUpdated, ImageFileDataTests.stringByteErrorNull);
		Mockito.when(imageDomainService.prepareToUpdate(ImageDataTests.imageOKCreated, ImageFileDataTests.stringByteOk)).thenReturn(ImageDataTests.imageOKCreated);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).prepareToUpdate(ImageDataTests.imageOKCreated, ImageFileDataTests.stringByteErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).prepareToUpdate(ImageDataTests.imageOKCreated, ImageFileDataTests.stringByteErrorNull);
		Mockito.when(imageDomainService.prepareToUpdate(ImageDataTests.imageOKCreatedImageEmpty, ImageFileDataTests.stringByteOk)).thenReturn(ImageDataTests.imageOKCreated);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).prepareToUpdate(ImageDataTests.imageOKCreatedImageEmpty, ImageFileDataTests.stringByteErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).prepareToUpdate(ImageDataTests.imageOKCreatedImageEmpty, ImageFileDataTests.stringByteErrorNull);
		Mockito.when(imageDomainService.prepareToUpdate(ImageDataTests.imageOKUpdatedImageEmpty, ImageFileDataTests.stringByteOk)).thenReturn(ImageDataTests.imageOKUpdated);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).prepareToUpdate(ImageDataTests.imageOKUpdatedImageEmpty, ImageFileDataTests.stringByteErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).prepareToUpdate(ImageDataTests.imageOKUpdatedImageEmpty, ImageFileDataTests.stringByteErrorNull);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).prepareToUpdate(ImageDataTests.imageErrorCreatedNotName, ImageFileDataTests.stringByteOk);
		Mockito.doThrow(ImageIdRequiredException.class).when(imageDomainService).prepareToUpdate(ImageDataTests.imageOKToCreate, ImageFileDataTests.stringByteOk);
		Mockito.doThrow(ImageIdRequiredException.class).when(imageDomainService).prepareToUpdate(ImageDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteOk);
		Mockito.when(imageDomainService.getById(ImageDataTests.imageOnlyId)).thenReturn(ImageDataTests.imageOnlyId);
		Mockito.doThrow(ImageIdRequiredException.class).when(imageDomainService).getById(ImageDataTests.imageOnlyIdEmpty);
		Mockito.doThrow(ImageIdRequiredException.class).when(imageDomainService).getById(ImageDataTests.imageOnlyIdNull);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).getById(ImageDataTests.imageErrorCreatedNotName);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).getById(ImageDataTests.imageErrorCreatedNotBody);
		Mockito.doThrow(ImageConvertException.class).when(imageDomainService).getById(ImageDataTests.imageErrorCreatedBodyEmpty);
		

		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageOnlyId)).thenReturn(ImageDtoDataTests.imageOnlyId);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageOnlyIdEmpty)).thenReturn(ImageDtoDataTests.imageOnlyIdEmpty);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageOnlyIdNull)).thenReturn(ImageDtoDataTests.imageOnlyIdNull);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageOKToCreate)).thenReturn(ImageDtoDataTests.imageOKToCreate);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageOKToCreateImageEmpty)).thenReturn(ImageDtoDataTests.imageOKToCreateImageEmpty);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageOKCreated)).thenReturn(ImageDtoDataTests.imageOKCreated);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageOKCreatedImageEmpty)).thenReturn(ImageDtoDataTests.imageOKCreatedImageEmpty);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageOKUpdated)).thenReturn(ImageDtoDataTests.imageOKUpdated);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageOKUpdatedImageEmpty)).thenReturn(ImageDtoDataTests.imageOKUpdatedImageEmpty);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageErrorCreatedBodyEmpty)).thenReturn(ImageDtoDataTests.imageErrorCreatedBodyEmpty);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageErrorCreatedIdBodyEmpty)).thenReturn(ImageDtoDataTests.imageErrorCreatedIdBodyEmpty);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageErrorCreatedIdNotBody)).thenReturn(ImageDtoDataTests.imageErrorCreatedIdNotBody);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageErrorCreatedIdNotName)).thenReturn(ImageDtoDataTests.imageErrorCreatedIdNotName);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageErrorCreatedNotBody)).thenReturn(ImageDtoDataTests.imageErrorCreatedNotBody);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageErrorCreatedNotName)).thenReturn(ImageDtoDataTests.imageErrorCreatedNotName);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageErrorNewBodyEmpty)).thenReturn(ImageDtoDataTests.imageErrorNewBodyEmpty);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageErrorNewNotBody)).thenReturn(ImageDtoDataTests.imageErrorNewNotBody);
		Mockito.when(imageWithDtoMapper.toDto(ImageDataTests.imageErrorNewNotName)).thenReturn(ImageDtoDataTests.imageErrorNewNotName);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOnlyId)).thenReturn(ImageDataTests.imageOnlyId);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOnlyIdEmpty)).thenReturn(ImageDataTests.imageOnlyIdEmpty);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOnlyIdNull)).thenReturn(ImageDataTests.imageOnlyIdNull);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOKToCreate)).thenReturn(ImageDataTests.imageOKToCreate);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOKToCreateImageEmpty)).thenReturn(ImageDataTests.imageOKToCreateImageEmpty);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOKCreated)).thenReturn(ImageDataTests.imageOKCreated);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOKCreatedImageEmpty)).thenReturn(ImageDataTests.imageOKCreatedImageEmpty);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOKUpdated)).thenReturn(ImageDataTests.imageOKUpdated);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageOKUpdatedImageEmpty)).thenReturn(ImageDataTests.imageOKUpdatedImageEmpty);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorCreatedBodyEmpty)).thenReturn(ImageDataTests.imageErrorCreatedBodyEmpty);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorCreatedIdBodyEmpty)).thenReturn(ImageDataTests.imageErrorCreatedIdBodyEmpty);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorCreatedIdNotBody)).thenReturn(ImageDataTests.imageErrorCreatedIdNotBody);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorCreatedIdNotName)).thenReturn(ImageDataTests.imageErrorCreatedIdNotName);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorCreatedNotBody)).thenReturn(ImageDataTests.imageErrorCreatedNotBody);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorCreatedNotName)).thenReturn(ImageDataTests.imageErrorCreatedNotName);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorNewBodyEmpty)).thenReturn(ImageDataTests.imageErrorNewBodyEmpty);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorNewNotBody)).thenReturn(ImageDataTests.imageErrorNewNotBody);
		Mockito.when(imageWithDtoMapper.toEntity(ImageDtoDataTests.imageErrorNewNotName)).thenReturn(ImageDataTests.imageErrorNewNotName);
	}

	@Test
	public void getById() {
		assertThat(imageService.getById(ImageDtoDataTests.imageOnlyId)).isEqualTo(ImageDtoDataTests.imageOnlyId);
		assertThrows(ImageIdRequiredException.class, () -> imageService.getById(ImageDtoDataTests.imageOnlyIdEmpty));
		assertThrows(ImageIdRequiredException.class, () -> imageService.getById(ImageDtoDataTests.imageOnlyIdNull));
		assertThrows(ImageConvertException.class, () -> imageService.getById(ImageDtoDataTests.imageErrorCreatedNotName));
		assertThrows(ImageConvertException.class, () -> imageService.getById(ImageDtoDataTests.imageErrorCreatedNotBody));
		assertThrows(ImageConvertException.class, () -> imageService.getById(ImageDtoDataTests.imageErrorCreatedBodyEmpty));
	}

	@Test
	public void prepareToCreate() {
		assertThat(imageService.prepareToCreate(ImageDtoDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteOk)).isEqualTo(ImageDtoDataTests.imageOKToCreate);
		assertThat(imageService.prepareToCreate(ImageDtoDataTests.imageOKToCreate, ImageFileDataTests.stringByteOk)).isEqualTo(ImageDtoDataTests.imageOKToCreate);
		assertThrows(ImageConvertException.class, () -> imageService.prepareToCreate(ImageDtoDataTests.imageErrorNewNotName, ImageFileDataTests.stringByteOk));
		assertThrows(ImageConvertException.class, () -> imageService.prepareToCreate(ImageDtoDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageService.prepareToCreate(ImageDtoDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteErrorNull));
	}

	@Test
	public void prepareToUpdate() {
		assertThat(imageService.prepareToUpdate(ImageDtoDataTests.imageOKUpdated, ImageFileDataTests.stringByteOk)).isEqualTo(ImageDtoDataTests.imageOKUpdated);
		assertThrows(ImageConvertException.class, () -> imageService.prepareToUpdate(ImageDtoDataTests.imageOKUpdated, ImageFileDataTests.stringByteErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageService.prepareToUpdate(ImageDtoDataTests.imageOKUpdated, ImageFileDataTests.stringByteErrorNull));

		assertThat(imageService.prepareToUpdate(ImageDtoDataTests.imageOKCreated, ImageFileDataTests.stringByteOk)).isEqualTo(ImageDtoDataTests.imageOKCreated);
		assertThrows(ImageConvertException.class, () -> imageService.prepareToUpdate(ImageDtoDataTests.imageOKCreated, ImageFileDataTests.stringByteErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageService.prepareToUpdate(ImageDtoDataTests.imageOKCreated, ImageFileDataTests.stringByteErrorNull));
				
		assertThat(imageService.prepareToUpdate(ImageDtoDataTests.imageOKCreatedImageEmpty, ImageFileDataTests.stringByteOk)).isEqualTo(ImageDtoDataTests.imageOKCreated);
		assertThrows(ImageConvertException.class, () -> imageService.prepareToUpdate(ImageDtoDataTests.imageOKCreatedImageEmpty, ImageFileDataTests.stringByteErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageService.prepareToUpdate(ImageDtoDataTests.imageOKCreatedImageEmpty, ImageFileDataTests.stringByteErrorNull));
				
		assertThat(imageService.prepareToUpdate(ImageDtoDataTests.imageOKUpdatedImageEmpty, ImageFileDataTests.stringByteOk)).isEqualTo(ImageDtoDataTests.imageOKUpdated);
		assertThrows(ImageConvertException.class, () -> imageService.prepareToUpdate(ImageDtoDataTests.imageOKUpdatedImageEmpty, ImageFileDataTests.stringByteErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageService.prepareToUpdate(ImageDtoDataTests.imageOKUpdatedImageEmpty, ImageFileDataTests.stringByteErrorNull));
		
		assertThrows(ImageConvertException.class, () -> imageService.prepareToUpdate(ImageDtoDataTests.imageErrorCreatedNotName, ImageFileDataTests.stringByteOk));
		assertThrows(ImageIdRequiredException.class, () -> imageService.prepareToUpdate(ImageDtoDataTests.imageOKToCreate, ImageFileDataTests.stringByteOk));
		assertThrows(ImageIdRequiredException.class, () -> imageService.prepareToUpdate(ImageDtoDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteOk));
	}

}
