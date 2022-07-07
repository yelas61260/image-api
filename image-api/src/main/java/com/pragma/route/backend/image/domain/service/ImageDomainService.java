package com.pragma.route.backend.image.domain.service;

import com.pragma.route.backend.image.domain.model.Image;

public interface ImageDomainService {
	
	public Image getById(Image image);
	public Image prepareToCreate(Image image, byte[] imageFile);
	public Image prepareToUpdate(Image image, byte[] imageFile);
	
}