package com.pragma.route.backend.image.application.service;

import com.pragma.route.backend.image.application.dto.ImageDto;

public interface ImageService {
	
	public ImageDto getById(ImageDto imageDTO);
	public ImageDto prepareToCreate(ImageDto imageDTO, byte[] imageFile);
	public ImageDto prepareToUpdate(ImageDto imageDTO, byte[] imageFile);
	
}