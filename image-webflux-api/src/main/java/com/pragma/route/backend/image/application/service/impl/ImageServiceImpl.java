package com.pragma.route.backend.image.application.service.impl;

import com.pragma.route.backend.image.application.dto.ImageDto;
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
	public ImageDto getById(ImageDto imageDto) {
		Image image = imageDomainService.getById(imageWithDtoMapper.toEntity(imageDto));
		return imageWithDtoMapper.toDto(image);
	}

	@Override
	public ImageDto prepareToCreate(ImageDto imageDto, byte[] imageFile) {
		Image image = imageDomainService.prepareToCreate(imageWithDtoMapper.toEntity(imageDto), imageFile);
		return imageWithDtoMapper.toDto(image);
	}

	@Override
	public ImageDto prepareToUpdate(ImageDto imageDto, byte[] imageFile) {
		Image image = imageDomainService.prepareToUpdate(imageWithDtoMapper.toEntity(imageDto), imageFile);
		return imageWithDtoMapper.toDto(image);
	}

}
