package com.pragma.route.backend.image.application.service.impl;

import com.pragma.route.backend.image.application.service.ImageConverterService;
import com.pragma.route.backend.image.domain.service.util.ImageConverterDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageConverterServiceImpl implements ImageConverterService {
	
	private ImageConverterDomainService imageConverterDomainService;

	@Override
	public String convertImageFileToBase64String(byte[] imageFile) {
		return imageConverterDomainService.convertImageFileToBase64String(imageFile);
	}

	@Override
	public byte[] convertBase64StringToImageFile(String imageString) {
		return imageConverterDomainService.convertBase64StringToImageFile(imageString);
	}

}
