package com.pragma.route.backend.image.application.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.ImageFileDataTests;
import com.pragma.route.backend.image.application.service.ImageConverterService;
import com.pragma.route.backend.image.domain.exception.conflict.ImageConvertException;
import com.pragma.route.backend.image.domain.service.util.ImageConverterDomainService;

@SpringBootTest
public class ImageConverterServiceImplTests {
	
	@Mock
	private ImageConverterDomainService imageConverterDomainService;
	
	private ImageConverterService imageConverterService;

	@BeforeEach
	public void setup() {
		imageConverterService = new ImageConverterServiceImpl(imageConverterDomainService);		

		Mockito.when(imageConverterDomainService.convertImageFileToBase64String(ImageFileDataTests.stringByteOk)).thenReturn(ImageFileDataTests.stringBaseOk);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterDomainService).convertImageFileToBase64String(ImageFileDataTests.stringByteErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterDomainService).convertImageFileToBase64String(ImageFileDataTests.stringByteErrorNull);

		Mockito.when(imageConverterDomainService.convertBase64StringToImageFile(ImageFileDataTests.stringBaseOk)).thenReturn(ImageFileDataTests.stringByteOk);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterDomainService).convertBase64StringToImageFile(ImageFileDataTests.stringBaseErrorEmpty);
		Mockito.doThrow(ImageConvertException.class).when(imageConverterDomainService).convertBase64StringToImageFile(ImageFileDataTests.stringBaseErrorNull);
	}
	
	@Test
	public void convertImageFileToBase64String() {
		assertThat(imageConverterService.convertImageFileToBase64String(ImageFileDataTests.stringByteOk)).isEqualTo(ImageFileDataTests.stringBaseOk);
		assertThrows(ImageConvertException.class, () -> imageConverterService.convertImageFileToBase64String(ImageFileDataTests.stringByteErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageConverterService.convertImageFileToBase64String(ImageFileDataTests.stringByteErrorNull));
	}

	@Test
	public void convertBase64StringToImageFile() {
		assertThat(imageConverterService.convertBase64StringToImageFile(ImageFileDataTests.stringBaseOk)).isEqualTo(ImageFileDataTests.stringByteOk);
		assertThrows(ImageConvertException.class, () -> imageConverterService.convertBase64StringToImageFile(ImageFileDataTests.stringBaseErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageConverterService.convertBase64StringToImageFile(ImageFileDataTests.stringBaseErrorNull));
	}

}
