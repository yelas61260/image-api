package com.pragma.route.backend.image.domain.service;

import com.pragma.route.backend.image.domain.model.Image;

public interface ImageDomainService {
	
	public Image getByAssociationTypeAndResourceId(int associationType, int resourceId);
	public Image prepareToCreate(int associationType, int resourceId, String imageName, byte[] imageFile);
	public Image prepareToUpdate(int associationType, int resourceId, String imageName, byte[] imageFile);
	
}