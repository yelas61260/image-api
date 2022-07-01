package com.pragma.route.backend.image.infrastructure.db.mapper;

import org.mapstruct.Mapper;

import com.pragma.route.backend.image.application.dto.ImageDTO;
import com.pragma.route.backend.image.infrastructure.db.entity.ImageMongoEntity;

@Mapper
public interface ImageMongoEntityWithDtoMapper {
	
	ImageDTO toDto(ImageMongoEntity imageEntity);
	ImageMongoEntity toMongoEntity(ImageDTO imageDTO);

}
