package com.pragma.route.backend.image.application.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Base64;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.application.service.ImageConverterService;
import com.pragma.route.backend.image.domain.exception.conflict.ImageManagerImageConvertException;
import com.pragma.route.backend.image.domain.service.util.ImageConverterDomainService;

@SpringBootTest
public class ImageConverterServiceImplTests {
	
	@Mock
	private ImageConverterDomainService imageConverterDomainService;
	
	private ImageConverterService imageConverterService;
	
	private String stringBase;
	private byte[] stringByte;

	@BeforeEach
	public void setup() {
		imageConverterService = new ImageConverterServiceImpl(imageConverterDomainService);
		
		String originalString = "Contenido";
		stringBase = Base64.getEncoder().encodeToString(originalString.getBytes());
		stringByte = Base64.getDecoder().decode(stringBase);		

		Mockito.when(imageConverterDomainService.convertBase64StringToImageFile(stringBase)).thenReturn(stringByte);
		Mockito.doThrow(ImageManagerImageConvertException.class).when(imageConverterDomainService).convertBase64StringToImageFile("");
		Mockito.doThrow(ImageManagerImageConvertException.class).when(imageConverterDomainService).convertBase64StringToImageFile(null);
		
		Mockito.when(imageConverterDomainService.convertImageFileToBase64String(stringByte)).thenReturn(stringBase);
		Mockito.doThrow(ImageManagerImageConvertException.class).when(imageConverterDomainService).convertImageFileToBase64String(new byte[0]);
		Mockito.doThrow(ImageManagerImageConvertException.class).when(imageConverterDomainService).convertImageFileToBase64String(null);
	}
	
	@Test
	public void convertImageFileToBase64String() {
		assertThat(imageConverterService.convertImageFileToBase64String(stringByte)).isEqualTo(stringBase);
		assertThrows(ImageManagerImageConvertException.class, () -> imageConverterService.convertImageFileToBase64String(null));
		assertThrows(ImageManagerImageConvertException.class, () -> imageConverterService.convertImageFileToBase64String(new byte[0]));
	}

	@Test
	public void convertBase64StringToImageFile() {
		assertThat(imageConverterService.convertBase64StringToImageFile(stringBase)).isEqualTo(stringByte);
		assertThrows(ImageManagerImageConvertException.class, () -> imageConverterService.convertBase64StringToImageFile(null));
		assertThrows(ImageManagerImageConvertException.class, () -> imageConverterService.convertBase64StringToImageFile(""));
	}

}
