package com.pragma.route.backend.image.infrastructure.db.mapper.impl;

import org.springframework.stereotype.Component;

import com.pragma.route.backend.image.application.dto.ImageDto;
import com.pragma.route.backend.image.infrastructure.db.entity.ImageMongoEntity;
import com.pragma.route.backend.image.infrastructure.db.mapper.ImageMongoEntityWithDtoMapper;

@Component
public class ImageMongoEntityWithDtoMapperImpl implements ImageMongoEntityWithDtoMapper {

	@Override
	public ImageDto toDto(ImageMongoEntity imageEntity) {
		return ImageDto.builder()
				.imageId(imageEntity.getId())
				.imageBase64(imageEntity.getBodyBase64())
				.imageName(imageEntity.getImageName())
				.build();
	}

	@Override
	public ImageMongoEntity toMongoEntity(ImageDto imageDTO) {
		return ImageMongoEntity.builder()
				.id(imageDTO.getImageId())
				.imageName(imageDTO.getImageName())
				.bodyBase64(imageDTO.getImageBase64())
				.build();
	}

}
