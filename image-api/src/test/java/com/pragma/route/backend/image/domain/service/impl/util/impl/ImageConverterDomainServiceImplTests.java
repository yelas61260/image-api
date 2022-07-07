package com.pragma.route.backend.image.domain.service.impl.util.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.ImageFileDataTests;
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
		assertThat(imageConverterDomainService.convertImageFileToBase64String(ImageFileDataTests.stringByteOk)).isEqualTo(ImageFileDataTests.stringBaseOk);
		assertThrows(ImageConvertException.class, () -> imageConverterDomainService.convertImageFileToBase64String(ImageFileDataTests.stringByteErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageConverterDomainService.convertImageFileToBase64String(ImageFileDataTests.stringByteErrorNull));
	}

	@Test
	public void convertBase64StringToImageFile() {	
		assertThat(imageConverterDomainService.convertBase64StringToImageFile(ImageFileDataTests.stringBaseOk)).isEqualTo(ImageFileDataTests.stringByteOk);
		assertThrows(ImageConvertException.class, () -> imageConverterDomainService.convertBase64StringToImageFile(ImageFileDataTests.stringBaseErrorContent));
		assertThrows(ImageConvertException.class, () -> imageConverterDomainService.convertBase64StringToImageFile(ImageFileDataTests.stringBaseErrorEmpty));
		assertThrows(ImageConvertException.class, () -> imageConverterDomainService.convertBase64StringToImageFile(ImageFileDataTests.stringBaseErrorNull));
	}
	
}