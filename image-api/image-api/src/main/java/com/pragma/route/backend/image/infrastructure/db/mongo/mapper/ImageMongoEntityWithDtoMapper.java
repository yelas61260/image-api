package com.pragma.route.backend.image.infrastructure.db.mongo.mapper;

import org.mapstruct.Mapper;

import com.pragma.route.backend.image.application.dto.ImageDto;
import com.pragma.route.backend.image.infrastructure.db.mongo.entity.ImageMongoEntity;

@Mapper
public interface ImageMongoEntityWithDtoMapper {
	
	ImageDto toDto(ImageMongoEntity imageEntity);
	ImageMongoEntity toMongoEntity(ImageDto imageDTO);

}
