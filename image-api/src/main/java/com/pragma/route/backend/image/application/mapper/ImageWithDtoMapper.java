package com.pragma.route.backend.image.application.mapper;

import org.mapstruct.Mapper;

import com.pragma.route.backend.image.application.dto.ImageDto;
import com.pragma.route.backend.image.domain.model.Image;

@Mapper
public interface ImageWithDtoMapper {
	
	ImageDto toDto(Image imageEntity);
	Image toEntity(ImageDto imageDTO);

}
