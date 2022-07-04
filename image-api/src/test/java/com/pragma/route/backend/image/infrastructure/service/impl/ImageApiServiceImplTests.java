package com.pragma.route.backend.image.infrastructure.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Base64;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import com.pragma.route.backend.image.application.dto.ImageDTO;
import com.pragma.route.backend.image.application.service.ImageConverterService;
import com.pragma.route.backend.image.application.service.ImageService;
import com.pragma.route.backend.image.domain.exception.conflict.ImageConvertException;
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

	private String stringBase;
	private byte[] stringByte;
	private ImageDTO imageDtoOk;
	private MockMultipartFile multipartFile;
	private MockMultipartFile multipartFileError;
	
	@BeforeEach
	public void setup() {
		imageApiService = new ImageApiServiceImpl(imageService, imageConverterService, imageRepository);

		String originalString = "Contenido";
		stringBase = Base64.getEncoder().encodeToString(originalString.getBytes());
		stringByte = Base64.getDecoder().decode(stringBase);
		multipartFile = new MockMultipartFile("imagen", stringByte);
		multipartFileError = new MockMultipartFile("imagen", new byte[0]);
		
		imageDtoOk = ImageDTO.builder()
				.associationType(1)
				.resourceId(1)
				.imageBase64(stringBase)
				.imageName("imagen")
				.build();
		
		Mockito.when(imageService.prepareToCreate(1, 1, "imagen", stringByte)).thenReturn(imageDtoOk);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToCreate(1, 1, "imagen", new byte[0]);
		Mockito.when(imageService.prepareToUpdate(1, 1, "imagen", stringByte)).thenReturn(imageDtoOk);
		Mockito.doThrow(ImageConvertException.class).when(imageService).prepareToUpdate(1, 1, "imagen", new byte[0]);
		Mockito.when(imageService.getByAssociationTypeAndResourceId(1, 1)).thenReturn(imageDtoOk);
		Mockito.when(imageService.getByAssociationTypeAndResourceId(1, 0)).thenReturn(null);
		Mockito.when(imageService.getByAssociationTypeAndResourceId(0, 1)).thenReturn(null);
		
		Mockito.when(imageRepository.create(imageDtoOk)).thenReturn(imageDtoOk);
		Mockito.when(imageRepository.update(imageDtoOk)).thenReturn(imageDtoOk);
		Mockito.when(imageRepository.getById(imageDtoOk)).thenReturn(imageDtoOk);
		
		Mockito.when(imageConverterService.convertBase64StringToImageFile(stringBase)).thenReturn(stringByte);
		Mockito.when(imageConverterService.convertImageFileToBase64String(stringByte)).thenReturn(stringBase);
	}

	@Test
	public void create() {
		assertThat(imageApiService.create(1, 1, multipartFile)).isEqualTo(imageDtoOk);
		assertThrows(ImageConvertException.class, () -> imageApiService.create(1, 1, null));
		assertThrows(ImageConvertException.class, () -> imageApiService.create(1, 1, multipartFileError));
	}

	@Test
	public void update() {
		assertThat(imageApiService.update(1, 1, multipartFile)).isEqualTo(imageDtoOk);
		assertThrows(ImageConvertException.class, () -> imageApiService.update(1, 1, null));
		assertThrows(ImageConvertException.class, () -> imageApiService.update(1, 1, multipartFileError));
	}

	@Test
	public void getImageBase64() {
		assertThat(imageApiService.getImageBase64(1, 1)).isEqualTo(stringBase);
		assertThrows(ImageNotFoundException.class, () -> imageApiService.getImageBase64(0, 1));
		assertThrows(ImageNotFoundException.class, () -> imageApiService.getImageBase64(1, 0));
	}

	@Test
	public void getImageFile() {
		assertThat(imageApiService.getImageFile(1, 1)).isEqualTo(stringByte);
		assertThrows(ImageNotFoundException.class, () -> imageApiService.getImageFile(0, 1));
		assertThrows(ImageNotFoundException.class, () -> imageApiService.getImageFile(1, 0));
	}

}
