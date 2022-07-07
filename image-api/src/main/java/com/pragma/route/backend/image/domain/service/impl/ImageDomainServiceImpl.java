package com.pragma.route.backend.image.domain.service.impl;

import com.pragma.route.backend.image.domain.exception.conflict.ImageIdConflictException;
import com.pragma.route.backend.image.domain.exception.conflict.ImageIdRequiredException;
import com.pragma.route.backend.image.domain.model.Image;
import com.pragma.route.backend.image.domain.service.ImageDomainService;
import com.pragma.route.backend.image.domain.service.util.ImageConverterDomainService;
import com.pragma.route.backend.image.domain.service.validator.ImageValidatorDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageDomainServiceImpl implements ImageDomainService {
	
	private final ImageValidatorDomainService imageValidatorService;
	private final ImageConverterDomainService imageConverterDomainService;

	@Override
	public Image prepareToCreate(Image image, byte[] imageFile) {
		if (image.getImageId() != null) {
			throw new ImageIdConflictException();
		}
		Image imageResponse = image.clone();
		imageResponse.setBodyBase64(this.imageConverterDomainService.convertImageFileToBase64String(imageFile));		
		imageValidatorService.validateImage(imageResponse);
			
		return imageResponse;
	}

	@Override
	public Image prepareToUpdate(Image image, byte[] imageFile) {
		if (image.getImageId() == null) {
			throw new ImageIdRequiredException();
		}
		Image imageResponse = image.clone();
		imageResponse.setBodyBase64(this.imageConverterDomainService.convertImageFileToBase64String(imageFile));		
		imageValidatorService.validateImage(imageResponse);

		return imageResponse;
	}

	@Override
	public Image getById(Image image) {
		Image imageResponse = image.clone();
		if (imageResponse.getImageId() == null || imageResponse.getImageId().isEmpty()) {
			throw new ImageIdRequiredException();
		}
		imageValidatorService.validateImage(imageResponse);
		return imageResponse;
	}

}
