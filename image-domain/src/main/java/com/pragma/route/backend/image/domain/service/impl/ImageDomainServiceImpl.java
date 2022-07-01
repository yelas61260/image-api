package com.pragma.route.backend.image.domain.service.impl;

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
	public Image prepareToCreate(int associationType, int resourceId, String imageName, byte[] imageFile) {
		Image image = Image.builder()
				.associationType(associationType)
				.resourceId(resourceId)
				.imageName(imageName)
				.bodyBase64(this.imageConverterDomainService.convertImageFileToBase64String(imageFile))
				.build();
		
		imageValidatorService.validateImage(image);
			
		return image;
	}

	@Override
	public Image prepareToUpdate(int associationType, int resourceId, String imageName, byte[] imageFile) {
		Image image = Image.builder()
				.associationType(associationType)
				.resourceId(resourceId)
				.imageName(imageName)
				.bodyBase64(this.imageConverterDomainService.convertImageFileToBase64String(imageFile))
				.build();
		
		imageValidatorService.validateImage(image);

		return image;
	}

	@Override
	public Image getByAssociationTypeAndResourceId(int associationType, int resourceId) {
		Image image = Image.builder()
				.associationType(associationType)
				.resourceId(resourceId)
				.build();
		
		imageValidatorService.validateImage(image);
		
		return image;
	}

}
