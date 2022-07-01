package com.pragma.route.backend.image.domain.service.validator.impl;

import com.pragma.route.backend.image.domain.exception.conflict.ImageManagerResourceIdInvalidException;
import com.pragma.route.backend.image.domain.model.Image;
import com.pragma.route.backend.image.domain.service.validator.ImageValidatorDomainService;
import com.pragma.route.backend.image.domain.service.validator.ResourceValidatorDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageValidatorDomainServiceImpl implements ImageValidatorDomainService {
	
	private final ResourceValidatorDomainService resourceValidatorService;

	@Override
	public void validateImage(Image image) {
		if (image.getResourceId() <= 0) {
			throw new ImageManagerResourceIdInvalidException();
		}
		resourceValidatorService.validateResourceTypeById(image.getAssociationType());
	}

}
