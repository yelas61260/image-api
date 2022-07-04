package com.pragma.route.backend.image.domain.service.impl.util.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Base64;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.domain.exception.conflict.ImageConvertException;
import com.pragma.route.backend.image.domain.service.util.ImageConverterDomainService;
import com.pragma.route.backend.image.domain.service.util.impl.ImageConverterDomainServiceImpl;

@SpringBootTest
public class ImageConverterDomainServiceImplTests {
	
	private ImageConverterDomainService imageConverterDomainService;

	@BeforeEach
	public void setup() {
		imageConverterDomainService = new ImageConverterDomainServiceImpl();
	}
	
	@Test
	public void convertImageFileToBase64String() {
		String originalString = "Contenido";
		String stringBase = Base64.getEncoder().encodeToString(originalString.getBytes());
		byte[] stringByte = Base64.getDecoder().decode(stringBase);
		byte[] stringByteError = new byte[0];
		
		assertThat(imageConverterDomainService.convertImageFileToBase64String(stringByte)).isEqualTo(stringBase);
		assertThrows(ImageConvertException.class, () -> imageConverterDomainService.convertImageFileToBase64String(stringByteError));
	}

	@Test
	public void convertBase64StringToImageFile() {
		String originalString = "Contenido";
		String stringBase = Base64.getEncoder().encodeToString(originalString.getBytes());
		byte[] stringByte = Base64.getDecoder().decode(stringBase);
		String stringError = null;

		assertThat(imageConverterDomainService.convertBase64StringToImageFile(stringBase)).isEqualTo(stringByte);
		assertThrows(ImageConvertException.class, () -> imageConverterDomainService.convertBase64StringToImageFile(stringError));
	}
	
}
