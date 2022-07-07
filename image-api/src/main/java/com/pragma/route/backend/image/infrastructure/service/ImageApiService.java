package com.pragma.route.backend.image.infrastructure.service;

import org.springframework.web.multipart.MultipartFile;

import com.pragma.route.backend.image.application.dto.ImageDto;

public interface ImageApiService {
	
	public ImageDto create(MultipartFile imageFile);
	public ImageDto update(String imageId, MultipartFile imageFile);
	public String getImageBase64(String imageId);
	public byte[] getImageFile(String imageId);

}
