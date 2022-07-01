package com.pragma.route.backend.image.infrastructure.db.repository;

import com.pragma.route.backend.image.application.dto.ImageDTO;

public interface ImageRepository {
	
	public ImageDTO getById(ImageDTO imageDTO);
	public ImageDTO create(ImageDTO imageDTO);
	public ImageDTO update(ImageDTO imageDTO);

}
