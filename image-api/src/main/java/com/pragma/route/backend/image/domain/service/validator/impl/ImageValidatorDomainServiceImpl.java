package com.pragma.route.backend.image.domain.service.validator.impl;

import com.pragma.route.backend.image.domain.exception.conflict.ImageConvertException;
import com.pragma.route.backend.image.domain.model.Image;
import com.pragma.route.backend.image.domain.service.validator.ImageValidatorDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageValidatorDomainServiceImpl implements ImageValidatorDomainService {

	@Override
	public void validateImage(Image image) {
		if (image.getImageName() == null) {
			throw new ImageConvertException();
		}
		if (image.getBodyBase64() == null || image.getBodyBase64().isEmpty()) {
			throw new ImageConvertException();
		}
	}

}
