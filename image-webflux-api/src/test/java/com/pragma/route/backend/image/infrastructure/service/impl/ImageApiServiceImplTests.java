package com.pragma.route.backend.image.infrastructure.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.pragma.route.backend.image.ImageDtoDataTests;
import com.pragma.route.backend.image.ImageFileDataTests;
import com.pragma.route.backend.image.application.service.ImageConverterService;
import com.pragma.route.backend.image.application.service.ImageService;
import com.pragma.route.backend.image.domain.exception.conflict.ImageConvertException;
import com.pragma.route.backend.image.domain.exception.conflict.ImageIdRequiredException;
import com.pragma.route.backend.image.domain.exception.notfound.ImageNotFoundException;
import com.pragma.route.backend.image.infrastructure.db.repository.ImageRepository;
import com.pragma.route.backend.image.infrastructure.service.ImageApiService;

@SpringBootTest
public class ImageApiServiceImplTests {
	
	@Mock
	private ImageService imageService;
	
	@Mock
	private ImageConverterService imageConverterService;
	
	@Mock
	private ImageRepository imageRepository;
	
	private ImageApiService imageApiService;
	
	@BeforeEach
	public void setup() {
		imageApiService = new ImageApiServiceImpl(imageService, imageConverterService, imageRepository);
		
		Mockito.when(imageRepository.getById(ImageDtoDataTests.imageOnlyIdEmpty.getImageId())).thenReturn(null);
		Mockito.when(imageRepository.getById(ImageDtoDataTests.imageOKToCreate.getImageId())).thenReturn(null);
		Mockito.when(imageRepository.getById(ImageDtoDataTests.imageOnlyId.getImageId())).thenReturn(ImageDtoDataTests.imageOKCreated);
		Mockito.when(imageRepository.getById(ImageDtoDataTests.imageOKUpdated.getImageId())).thenReturn(ImageDtoDataTests.imageOKUpdated);
		
		Mockito.when(imageRepository.create(ImageDtoDataTests.imageOKToCreate)).thenReturn(ImageDtoDataTests.imageOKCreated);
		Mockito.when(imageRepository.update(ImageDtoDataTests.imageOKCreated)).thenReturn(ImageDtoDataTests.imageOKCreated);
		Mockito.when(imageRepository.update(ImageDtoDataTests.imageOKUpdated)).thenReturn(ImageDtoDataTests.imageOKUpdated);

		Mockito.when(imageConverterService.convertImageFileToBase64String(ImageFileDataTests.stringByteOk)).thenReturn(ImageFileDataTests.stringBaseOk);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterService).convertImageFileToBase64String(ImageFileDataTests.stringByteErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterService).convertImageFileToBase64String(ImageFileDataTests.stringByteErrorNull);
		Mockito.when(imageConverterService.convertBase64StringToImageFile(ImageFileDataTests.stringBaseOk)).thenReturn(ImageFileDataTests.stringByteOk);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterService).convertBase64StringToImageFile(ImageFileDataTests.stringBaseErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterService).convertBase64StringToImageFile(ImageFileDataTests.stringBaseErrorNull);

		Mockito.when(imageService.getById(ImageDtoDataTests.imageOKCreated)).thenReturn(ImageDtoDataTests.imageOKCreated);
		Mockito.doThrow(ImageIdRequiredException.class).when(imageService).getById(ImageDtoDataTests.imageOnlyIdEmpty);
		Mockito.doThrow(ImageIdRequiredException.class).when(imageService).getById(ImageDtoDataTests.imageOnlyIdNull);
		Mockito.doThrow(ImageConvertException.class).when(imageService).getById(ImageDtoDataTests.imageErrorCreatedNotName);
		Mockito.doThrow(ImageConvertException.class).when(imageService).getById(ImageDtoDataTests.imageErrorCreatedNotBody);
		Mockito.doThrow(ImageConvertException.class).when(imageService).getById(ImageDtoDataTests.imageErrorCreatedBodyEmpty);
		Mockito.when(imageService.prepareToCreate(ImageDtoDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteOk)).thenReturn(ImageDtoDataTests.imageOKToCreate);
		Mockito.when(imageService.prepareToCreate(ImageDtoDataTests.imageOKToCreate, ImageFileDataTests.stringByteOk)).thenReturn(ImageDtoDataTests.imageOKToCreate);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToCreate(ImageDtoDataTests.imageErrorNewNotName, ImageFileDataTests.stringByteOk);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToCreate(ImageDtoDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToCreate(ImageDtoDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteErrorNull);
		Mockito.when(imageService.prepareToUpdate(ImageDtoDataTests.imageOKUpdated, ImageFileDataTests.stringByteOk)).thenReturn(ImageDtoDataTests.imageOKUpdated);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToUpdate(ImageDtoDataTests.imageOKUpdated, ImageFileDataTests.stringByteErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToUpdate(ImageDtoDataTests.imageOKUpdated, ImageFileDataTests.stringByteErrorNull);
		Mockito.when(imageService.prepareToUpdate(ImageDtoDataTests.imageOKCreated, ImageFileDataTests.stringByteOk)).thenReturn(ImageDtoDataTests.imageOKCreated);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToUpdate(ImageDtoDataTests.imageOKCreated, ImageFileDataTests.stringByteErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToUpdate(ImageDtoDataTests.imageOKCreated, ImageFileDataTests.stringByteErrorNull);
		Mockito.when(imageService.prepareToUpdate(ImageDtoDataTests.imageOKCreatedImageEmpty, ImageFileDataTests.stringByteOk)).thenReturn(ImageDtoDataTests.imageOKCreated);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToUpdate(ImageDtoDataTests.imageOKCreatedImageEmpty, ImageFileDataTests.stringByteErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToUpdate(ImageDtoDataTests.imageOKCreatedImageEmpty, ImageFileDataTests.stringByteErrorNull);
		Mockito.when(imageService.prepareToUpdate(ImageDtoDataTests.imageOKUpdatedImageEmpty, ImageFileDataTests.stringByteOk)).thenReturn(ImageDtoDataTests.imageOKUpdated);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToUpdate(ImageDtoDataTests.imageOKUpdatedImageEmpty, ImageFileDataTests.stringByteErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToUpdate(ImageDtoDataTests.imageOKUpdatedImageEmpty, ImageFileDataTests.stringByteErrorNull);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToUpdate(ImageDtoDataTests.imageErrorCreatedNotName, ImageFileDataTests.stringByteOk);
		Mockito.doThrow(ImageIdRequiredException.class).when(imageService).prepareToUpdate(ImageDtoDataTests.imageOKToCreate, ImageFileDataTests.stringByteOk);
		Mockito.doThrow(ImageIdRequiredException.class).when(imageService).prepareToUpdate(ImageDtoDataTests.imageOKToCreateImageEmpty, ImageFileDataTests.stringByteOk);
	}

	@Test
	public void create() {
		assertThat(imageApiService.create(ImageFileDataTests.multipartFileOk)).isEqualTo(ImageDtoDataTests.imageOKCreated);
		assertThrows(ImageConvertException.class, () -> imageApiService.create(ImageFileDataTests.multipartFileErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageApiService.create(ImageFileDataTests.multipartFileErrorNull));
		assertThrows(ImageConvertException.class, () -> imageApiService.create(new MockMultipartFile("image", "mi imagen", null, InputStream.nullInputStream())));
		assertThrows(ImageConvertException.class, () -> imageApiService.create(null));
	}

	@Test
	public void update() {
		assertThat(imageApiService.update(ImageDtoDataTests.imageOKUpdated.getImageId(), ImageFileDataTests.multipartFileOk)).isEqualTo(ImageDtoDataTests.imageOKUpdated);
		assertThrows(ImageIdRequiredException.class, () -> imageApiService.update(ImageDtoDataTests.imageOKToCreate.getImageId(), ImageFileDataTests.multipartFileOk));
		assertThrows(ImageConvertException.class, () -> imageApiService.update(ImageDtoDataTests.imageOKUpdated.getImageId(), ImageFileDataTests.multipartFileErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageApiService.update(ImageDtoDataTests.imageOKUpdated.getImageId(), ImageFileDataTests.multipartFileErrorNull));
		assertThrows(ImageConvertException.class, () -> imageApiService.update(ImageDtoDataTests.imageOKUpdated.getImageId(), new MockMultipartFile("image", "mi imagen", null, InputStream.nullInputStream())));
		assertThrows(ImageConvertException.class, () -> imageApiService.update(ImageDtoDataTests.imageOKUpdated.getImageId(), null));
		assertThrows(ImageNotFoundException.class, () -> imageApiService.update("NoExiste", ImageFileDataTests.multipartFileOk));
	}

	@Test
	public void getImageBase64() {
		assertThat(imageApiService.getImageBase64(ImageDtoDataTests.imageOKCreated.getImageId())).isEqualTo(ImageFileDataTests.stringBaseOk);
		assertThrows(ImageNotFoundException.class, () -> imageApiService.getImageBase64(ImageDtoDataTests.imageOnlyIdEmpty.getImageId()));
		assertThrows(ImageNotFoundException.class, () -> imageApiService.getImageBase64(null));
	}

	@Test
	public void getImageFile() {
		assertThat(imageApiService.getImageFile(ImageDtoDataTests.imageOKCreated.getImageId())).isEqualTo(ImageFileDataTests.stringByteOk);
		assertThrows(ImageNotFoundException.class, () -> imageApiService.getImageFile(ImageDtoDataTests.imageOnlyIdEmpty.getImageId()));
		assertThrows(ImageNotFoundException.class, () -> imageApiService.getImageFile(null));
	}

}
