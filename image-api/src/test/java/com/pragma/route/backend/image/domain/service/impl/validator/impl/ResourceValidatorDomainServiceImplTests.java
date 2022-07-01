package com.pragma.route.backend.image.domain.service.impl.validator.impl;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.pragma.route.backend.image.domain.exception.notfound.ImageManagerResourceTypeNotFoundException;
import com.pragma.route.backend.image.domain.service.validator.ResourceValidatorDomainService;
import com.pragma.route.backend.image.domain.service.validator.impl.ResourceValidatorDomainServiceImpl;

@SpringBootTest
public class ResourceValidatorDomainServiceImplTests {
	
	private ResourceValidatorDomainService resourceValidatorDomainService;
	
	@BeforeEach
	public void setup() {
		resourceValidatorDomainService = new ResourceValidatorDomainServiceImpl();
	}

	@Test
	public void validateResourceTypeById() {
		assertDoesNotThrow(() -> resourceValidatorDomainService.validateResourceTypeById(1));
		assertThrows(ImageManagerResourceTypeNotFoundException.class, () -> resourceValidatorDomainService.validateResourceTypeById(100));
		assertThrows(ImageManagerResourceTypeNotFoundException.class, () -> resourceValidatorDomainService.validateResourceTypeById(0));
	}

}
