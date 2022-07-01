package com.pragma.route.backend.image.application.mapper;

import org.mapstruct.Mapper;

import com.pragma.route.backend.image.application.dto.ImageDTO;
import com.pragma.route.backend.image.domain.model.Image;

@Mapper
public interface ImageWithDtoMapper {
	
	ImageDTO toDto(Image imageEntity);
	Image toEntity(ImageDTO imageDTO);

}
