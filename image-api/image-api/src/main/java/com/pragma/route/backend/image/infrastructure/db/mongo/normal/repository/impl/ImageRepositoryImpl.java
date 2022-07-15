package com.pragma.route.backend.image.infrastructure.db.mongo.normal.repository.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.pragma.route.backend.image.application.dto.ImageDto;
import com.pragma.route.backend.image.infrastructure.db.mongo.entity.ImageMongoEntity;
import com.pragma.route.backend.image.infrastructure.db.mongo.mapper.ImageMongoEntityWithDtoMapper;
import com.pragma.route.backend.image.infrastructure.db.mongo.normal.dao.ImageDao;
import com.pragma.route.backend.image.infrastructure.db.mongo.normal.repository.ImageRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ImageRepositoryImpl implements ImageRepository {
	
	private final ImageDao imageDao;
	private final ImageMongoEntityWithDtoMapper imageMongoEntityWithDtoMapper;

	@Override
	public ImageDto getById(String imageId) {
		Optional<ImageMongoEntity> imageEntity = imageDao.findById(imageId);
		if (imageEntity.isEmpty()) {
			return null;
		} else {
			return imageMongoEntityWithDtoMapper.toDto(imageEntity.get());
		}
	}

	@Override
	public ImageDto create(ImageDto imageDTO) {
		ImageMongoEntity imageMongoEntity = imageMongoEntityWithDtoMapper.toMongoEntity(imageDTO);
		return imageMongoEntityWithDtoMapper.toDto(imageDao.insert(imageMongoEntity));
	}

	@Override
	public ImageDto update(ImageDto imageDTO) {
		ImageMongoEntity imageMongoEntity = imageMongoEntityWithDtoMapper.toMongoEntity(imageDTO);
		return imageMongoEntityWithDtoMapper.toDto(imageDao.save(imageMongoEntity));
	}

}
