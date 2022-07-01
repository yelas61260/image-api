package com.pragma.route.backend.image.application.mapper.impl;

import com.pragma.route.backend.image.application.dto.ImageDTO;
import com.pragma.route.backend.image.application.mapper.ImageWithDtoMapper;
import com.pragma.route.backend.image.domain.model.Image;

public class ImageWithDtoMapperImpl implements ImageWithDtoMapper {

	@Override
	public ImageDTO toDto(Image imageEntity) {
		return ImageDTO.builder()
				.imageBase64(imageEntity.getBodyBase64())
				.associationType(imageEntity.getAssociationType())
				.resourceId(imageEntity.getResourceId())
				.imageName(imageEntity.getImageName())
				.build();
	}

	@Override
	public Image toEntity(ImageDTO imageDTO) {
		return Image.builder()
				.bodyBase64(imageDTO.getImageBase64())
				.associationType(imageDTO.getAssociationType())
				.resourceId(imageDTO.getResourceId())
				.imageName(imageDTO.getImageName())
				.build();
	}

}
