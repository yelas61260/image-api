package com.pragma.route.backend.image.domain.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.ImageDataTests;
import com.pragma.route.backend.image.ImageFileDataTests;
import com.pragma.route.backend.image.domain.exception.conflict.ImageConvertException;
import com.pragma.route.backend.image.domain.exception.conflict.ImageIdConflictException;
import com.pragma.route.backend.image.domain.exception.conflict.ImageIdRequiredException;
import com.pragma.route.backend.image.domain.service.ImageDomainService;
import com.pragma.route.backend.image.domain.service.util.ImageConverterDomainService;
import com.pragma.route.backend.image.domain.service.validator.ImageValidatorDomainService;

@SpringBootTest
public class ImageDomainServiceImplTests {
	
	@Mock
	private ImageValidatorDomainService imageValidatorDomainService;
	
	@Mock
	private ImageConverterDomainService imageConverterDomainService;
	
	private ImageDomainService imageDomainService;
	
	@BeforeEach
	public void setup() {
		imageDomainService = new ImageDomainServiceImpl(imageValidatorDomainService, imageConverterDomainService);		

		Mockito.when(imageConverterDomainService.convertImageFileToBase64String(ImageFileDataTests.stringByteOk)).thenReturn(ImageFileDataTests.stringBaseOk);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterDomainService).convertImageFileToBase64String(ImageFileDataTests.stringByteErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterDomainService).convertImageFileToBase64String(ImageFileDataTests.stringByteErrorNull);
		Mockito.when(imageConverterDomainService.convertBase64StringToImageFile(ImageFileDataTests.stringBaseOk)).thenReturn(ImageFileDataTests.stringByteOk);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterDomainService).convertBase64StringToImageFile(ImageFileDataTests.stringBaseErrorContent);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterDomainService).convertBase64StringToImageFile(ImageFileDataTests.stringBaseErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterDomainService).convertBase64StringToImageFile(ImageFileDataTests.stringBaseErrorNull);
		
		Mockito.doNothing().when(imageValidatorDomainService).validateImage(ImageDataTests.imageOKToCreate);
		Mockito.doNothing().when(imageValidatorDomainService).validateImage(ImageDataTests.imageOKCreated);
		Mockito.doNothing().when(imageValidatorDomainService).validateImage(ImageDataTests.imageOKUpdated);
		Mockito.doThrow(ImageConvertException.class).when(imageValidatorDomainService).validateImage(ImageDataTests.imageErrorNewNotName);
		Mockito.doThrow(ImageConvertException.class).when(imageValidatorDomainService).validateImage(ImageDataTests.imageErrorNewNotBody);
		Mockito.doThrow(ImageConvertException.class).when(imageValidatorDomainService).validateImage(ImageDataTests.imageErrorNewBodyEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageValidatorDomainService).validateImage(ImageDataTests.imageErrorCreatedNotName);
		Mockito.doThrow(ImageConvertException.class).when(imageValidatorDomainService).validateImage(ImageDataTests.imageErrorCreatedNotBody);
		Mockito.doThrow(ImageConvertException.class).when(imageValidatorDomainService).validateImage(ImageDataTests.imageErrorCreatedBodyEmpty);		

		Mockito.doNothing().when(imageValidatorDomainService).validateImage(ImageDataTests.imageOnlyId);
		Mockito.doThrow(ImageConvertException.class).when(imageValidatorDomainService).validateImage(ImageDataTests.imageErrorCreatedIdNotName);
		Mockito.doThrow(ImageConvertException.class).when(imageValidatorDomainService).validateImage(ImageDataTests.imageErrorCreatedIdNotBody);
		Mockito.doThrow(ImageConvertException.class).when(imageValidatorDomainService).validateImage(ImageDataTests.imageErrorCreatedIdBodyEmpty);
	}

	@Test
	public void prepareToCreate() {
		assertThat(imageDomainService.prepareToCreate(ImageDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteOk)).isEqualTo(ImageDataTests.imageOKToCreate);
		assertThat(imageDomainService.prepareToCreate(ImageDataTests.imageOKToCreate, ImageFileDataTests.stringByteOk)).isEqualTo(ImageDataTests.imageOKToCreate);
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToCreate(ImageDataTests.imageErrorNewNotName, ImageFileDataTests.stringByteOk));
		assertThrows(ImageIdConflictException.class, () -> imageDomainService.prepareToCreate(ImageDataTests.imageOKCreated, ImageFileDataTests.stringByteOk));
		assertThrows(ImageIdConflictException.class, () -> imageDomainService.prepareToCreate(ImageDataTests.imageOKCreatedImageEmpty, ImageFileDataTests.stringByteOk));
		assertThrows(ImageIdConflictException.class, () -> imageDomainService.prepareToCreate(ImageDataTests.imageOKUpdated, ImageFileDataTests.stringByteOk));
		assertThrows(ImageIdConflictException.class, () -> imageDomainService.prepareToCreate(ImageDataTests.imageOKUpdatedImageEmpty, ImageFileDataTests.stringByteOk));
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToCreate(ImageDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToCreate(ImageDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteErrorNull));
	}

	@Test
	public void prepareToUpdate() {
		assertThat(imageDomainService.prepareToUpdate(ImageDataTests.imageOKUpdated, ImageFileDataTests.stringByteOk)).isEqualTo(ImageDataTests.imageOKUpdated);
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToUpdate(ImageDataTests.imageOKUpdated, ImageFileDataTests.stringByteErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToUpdate(ImageDataTests.imageOKUpdated, ImageFileDataTests.stringByteErrorNull));

		assertThat(imageDomainService.prepareToUpdate(ImageDataTests.imageOKCreated, ImageFileDataTests.stringByteOk)).isEqualTo(ImageDataTests.imageOKCreated);
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToUpdate(ImageDataTests.imageOKCreated, ImageFileDataTests.stringByteErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToUpdate(ImageDataTests.imageOKCreated, ImageFileDataTests.stringByteErrorNull));
				
		assertThat(imageDomainService.prepareToUpdate(ImageDataTests.imageOKCreatedImageEmpty, ImageFileDataTests.stringByteOk)).isEqualTo(ImageDataTests.imageOKCreated);
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToUpdate(ImageDataTests.imageOKCreatedImageEmpty, ImageFileDataTests.stringByteErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToUpdate(ImageDataTests.imageOKCreatedImageEmpty, ImageFileDataTests.stringByteErrorNull));
				
		assertThat(imageDomainService.prepareToUpdate(ImageDataTests.imageOKUpdatedImageEmpty, ImageFileDataTests.stringByteOk)).isEqualTo(ImageDataTests.imageOKUpdated);
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToUpdate(ImageDataTests.imageOKUpdatedImageEmpty, ImageFileDataTests.stringByteErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToUpdate(ImageDataTests.imageOKUpdatedImageEmpty, ImageFileDataTests.stringByteErrorNull));
		
		assertThrows(ImageConvertException.class, () -> imageDomainService.prepareToUpdate(ImageDataTests.imageErrorCreatedNotName, ImageFileDataTests.stringByteOk));
		assertThrows(ImageIdRequiredException.class, () -> imageDomainService.prepareToUpdate(ImageDataTests.imageOKToCreate, ImageFileDataTests.stringByteOk));
		assertThrows(ImageIdRequiredException.class, () -> imageDomainService.prepareToUpdate(ImageDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteOk));
	}

	@Test
	public void getById() {		
		assertThat(imageDomainService.getById(ImageDataTests.imageOnlyId)).isEqualTo(ImageDataTests.imageOnlyId);
		assertThrows(ImageIdRequiredException.class, () -> imageDomainService.getById(ImageDataTests.imageOnlyIdEmpty));
		assertThrows(ImageIdRequiredException.class, () -> imageDomainService.getById(ImageDataTests.imageOnlyIdNull));
		assertThrows(ImageConvertException.class, () -> imageDomainService.getById(ImageDataTests.imageErrorCreatedNotName));
		assertThrows(ImageConvertException.class, () -> imageDomainService.getById(ImageDataTests.imageErrorCreatedNotBody));
		assertThrows(ImageConvertException.class, () -> imageDomainService.getById(ImageDataTests.imageErrorCreatedBodyEmpty));
	}

}
