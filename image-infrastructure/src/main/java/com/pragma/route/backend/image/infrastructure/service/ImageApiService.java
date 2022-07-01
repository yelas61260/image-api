package com.pragma.route.backend.image.infrastructure.service;

import org.springframework.web.multipart.MultipartFile;

import com.pragma.route.backend.image.application.dto.ImageDTO;

public interface ImageApiService {
	
	public ImageDTO create(int associationType, int resourceId, MultipartFile imageFile);
	public ImageDTO update(int associationType, int resourceId, MultipartFile imageFile);
	public String getImageBase64(int associationType, int resourceId);
	public byte[] getImageFile(int associationType, int resourceId);

}
