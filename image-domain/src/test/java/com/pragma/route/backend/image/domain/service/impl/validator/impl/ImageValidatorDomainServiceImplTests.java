package com.pragma.route.backend.image.domain.service.impl.validator.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.domain.exception.conflict.ImageManagerResourceIdInvalidException;
import com.pragma.route.backend.image.domain.exception.notfound.ImageManagerResourceTypeNotFoundException;
import com.pragma.route.backend.image.domain.model.Image;
import com.pragma.route.backend.image.domain.service.validator.ImageValidatorDomainService;
import com.pragma.route.backend.image.domain.service.validator.ResourceValidatorDomainService;
import com.pragma.route.backend.image.domain.service.validator.impl.ImageValidatorDomainServiceImpl;

@SpringBootTest
public class ImageValidatorDomainServiceImplTests {
	
	private ImageValidatorDomainService imageValidatorDomainService;
	
	@Mock
	private ResourceValidatorDomainService resourceValidatorService;
	
	@BeforeEach
	public void setup() {
		imageValidatorDomainService = new ImageValidatorDomainServiceImpl(resourceValidatorService);
		
		Mockito.doNothing().when(resourceValidatorService).validateResourceTypeById(1);
		Mockito.doThrow(ImageManagerResourceTypeNotFoundException.class).when(resourceValidatorService).validateResourceTypeById(0);
		Mockito.doThrow(ImageManagerResourceTypeNotFoundException.class).when(resourceValidatorService).validateResourceTypeById(100);
	}

	@Test
	public void validateImage() {
		Image imageOK = Image.builder()
				.associationType(1)
				.resourceId(1)
				.imageName("mi imagen")
				.bodyBase64("content")
				.build();
		Image imageERROR1 = Image.builder()
				.associationType(0)
				.resourceId(1)
				.imageName("mi imagen")
				.bodyBase64("content")
				.build();
		Image imageERROR2 = Image.builder()
				.associationType(1)
				.resourceId(0)
				.imageName("mi imagen")
				.bodyBase64("content")
				.build();
		
		assertDoesNotThrow(() -> imageValidatorDomainService.validateImage(imageOK));
		assertThrows(ImageManagerResourceTypeNotFoundException.class, () -> imageValidatorDomainService.validateImage(imageERROR1));
		assertThrows(ImageManagerResourceIdInvalidException.class, () -> imageValidatorDomainService.validateImage(imageERROR2));
	}

}
