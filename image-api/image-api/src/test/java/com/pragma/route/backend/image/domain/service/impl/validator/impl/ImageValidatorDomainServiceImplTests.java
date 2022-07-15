package com.pragma.route.backend.image.domain.service.impl.validator.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.ImageDataTests;
import com.pragma.route.backend.image.domain.exception.conflict.ImageConvertException;
import com.pragma.route.backend.image.domain.service.validator.ImageValidatorDomainService;
import com.pragma.route.backend.image.domain.service.validator.impl.ImageValidatorDomainServiceImpl;

@SpringBootTest
public class ImageValidatorDomainServiceImplTests {
	
	private ImageValidatorDomainService imageValidatorDomainService;
	
	@BeforeEach
	public void setup() {
		imageValidatorDomainService = new ImageValidatorDomainServiceImpl();
	}

	@Test
	public void validateImage() {
		assertDoesNotThrow(() -> imageValidatorDomainService.validateImage(ImageDataTests.imageOKToCreate));
		assertDoesNotThrow(() -> imageValidatorDomainService.validateImage(ImageDataTests.imageOKCreated));
		assertDoesNotThrow(() -> imageValidatorDomainService.validateImage(ImageDataTests.imageOKUpdated));
		assertThrows(ImageConvertException.class, () -> imageValidatorDomainService.validateImage(ImageDataTests.imageErrorNewNotName));
		assertThrows(ImageConvertException.class, () -> imageValidatorDomainService.validateImage(ImageDataTests.imageErrorNewNotBody));
		assertThrows(ImageConvertException.class, () -> imageValidatorDomainService.validateImage(ImageDataTests.imageErrorNewBodyEmpty));
		assertThrows(ImageConvertException.class, () -> imageValidatorDomainService.validateImage(ImageDataTests.imageErrorCreatedNotName));
		assertThrows(ImageConvertException.class, () -> imageValidatorDomainService.validateImage(ImageDataTests.imageErrorCreatedNotBody));
		assertThrows(ImageConvertException.class, () -> imageValidatorDomainService.validateImage(ImageDataTests.imageErrorCreatedBodyEmpty));
	}

}
