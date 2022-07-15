package com.pragma.route.backend.image.infrastructure.db.repository;

import com.pragma.route.backend.image.application.dto.ImageDto;

public interface ImageRepository {
	
	public ImageDto getById(String imageId);
	public ImageDto create(ImageDto imageDTO);
	public ImageDto update(ImageDto imageDTO);

}
