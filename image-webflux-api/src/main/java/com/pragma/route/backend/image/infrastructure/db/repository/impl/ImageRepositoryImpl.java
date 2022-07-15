package com.pragma.route.backend.image.infrastructure.db.repository.impl;

import org.springframework.stereotype.Repository;

import com.pragma.route.backend.image.application.dto.ImageDto;
import com.pragma.route.backend.image.infrastructure.db.dao.ImageDao;
import com.pragma.route.backend.image.infrastructure.db.entity.ImageMongoEntity;
import com.pragma.route.backend.image.infrastructure.db.mapper.ImageMongoEntityWithDtoMapper;
import com.pragma.route.backend.image.infrastructure.db.repository.ImageRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ImageRepositoryImpl implements ImageRepository {
	
	private final ImageDao imageDao;
	private final ImageMongoEntityWithDtoMapper imageMongoEntityWithDtoMapper;

	@Override
	public ImageDto getById(String imageId) {
		ImageDto imageEntity = imageDao.findById(imageId)
				.map(imageE -> imageMongoEntityWithDtoMapper.toDto(imageE))
				.block();
		return imageEntity;
	}

	@Override
	public ImageDto create(ImageDto imageDTO) {
		ImageMongoEntity imageMongoEntity = imageMongoEntityWithDtoMapper.toMongoEntity(imageDTO);
		return imageDao.insert(imageMongoEntity)
				.map(imageE -> imageMongoEntityWithDtoMapper.toDto(imageE))
				.block();
	}

	@Override
	public ImageDto update(ImageDto imageDTO) {
		ImageMongoEntity imageMongoEntity = imageMongoEntityWithDtoMapper.toMongoEntity(imageDTO);
		return imageDao.save(imageMongoEntity)
				.map(imageE-> imageMongoEntityWithDtoMapper.toDto(imageE))
				.block();
	}

}
