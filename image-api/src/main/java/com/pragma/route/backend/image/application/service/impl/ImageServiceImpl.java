package com.pragma.route.backend.image.application.service.impl;

import com.pragma.route.backend.image.application.dto.ImageDTO;
import com.pragma.route.backend.image.application.mapper.ImageWithDtoMapper;
import com.pragma.route.backend.image.application.service.ImageService;
import com.pragma.route.backend.image.domain.model.Image;
import com.pragma.route.backend.image.domain.service.ImageDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
	
	private ImageDomainService imageDomainService;
	private ImageWithDtoMapper imageWithDtoMapper;

	@Override
	public ImageDTO getByAssociationTypeAndResourceId(int associationType, int resourceId) {
		Image image = imageDomainService.getByAssociationTypeAndResourceId(associationType, resourceId);
		return imageWithDtoMapper.toDto(image);
	}

	@Override
	public ImageDTO prepareToCreate(int associationType, int resourceId, String imageName, byte[] imageFile) {
		Image image = imageDomainService.prepareToCreate(associationType, resourceId, imageName, imageFile);
		return imageWithDtoMapper.toDto(image);
	}

	@Override
	public ImageDTO prepareToUpdate(int associationType, int resourceId, String imageName, byte[] imageFile) {
		Image image = imageDomainService.prepareToUpdate(associationType, resourceId, imageName, imageFile);
		return imageWithDtoMapper.toDto(image);
	}

}
