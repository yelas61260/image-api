package com.pragma.route.backend.image.application.service;

import com.pragma.route.backend.image.application.dto.ImageDTO;

public interface ImageService {
	
	public ImageDTO getByAssociationTypeAndResourceId(int associationType, int resourceId);
	public ImageDTO prepareToCreate(int associationType, int resourceId, String imageName, byte[] imageFile);
	public ImageDTO prepareToUpdate(int associationType, int resourceId, String imageName, byte[] imageFile);
	
}