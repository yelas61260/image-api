package com.pragma.route.backend.image.application.mapper.impl;

import com.pragma.route.backend.image.application.dto.ImageDto;
import com.pragma.route.backend.image.application.mapper.ImageWithDtoMapper;
import com.pragma.route.backend.image.domain.model.Image;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageWithDtoMapperImpl implements ImageWithDtoMapper {

	@Override
	public ImageDto toDto(Image imageEntity) {
		return ImageDto.builder()
				.imageId(imageEntity.getImageId())
				.imageBase64(imageEntity.getBodyBase64())
				.imageName(imageEntity.getImageName())
				.build();
	}

	@Override
	public Image toEntity(ImageDto imageDTO) {
		return Image.builder()
				.imageId(imageDTO.getImageId())
				.bodyBase64(imageDTO.getImageBase64())
				.imageName(imageDTO.getImageName())
				.build();
	}

}
