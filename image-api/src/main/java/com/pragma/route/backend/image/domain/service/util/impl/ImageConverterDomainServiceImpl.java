package com.pragma.route.backend.image.domain.service.util.impl;

import java.util.Base64;

import com.pragma.route.backend.image.domain.exception.conflict.ImageConvertException;
import com.pragma.route.backend.image.domain.service.util.ImageConverterDomainService;

public class ImageConverterDomainServiceImpl implements ImageConverterDomainService {

	@Override
	public String convertImageFileToBase64String(byte[] imageFile) {
		if (imageFile == null || imageFile.length == 0) {
			throw new ImageConvertException();
		}
		try {
			return Base64.getEncoder().encodeToString(imageFile);
		} catch (Exception e) {
			throw new ImageConvertException();
		}
	}

	@Override
	public byte[] convertBase64StringToImageFile(String imageString) {
		if (imageString == null || imageString.length() == 0) {
			throw new ImageConvertException();
		}
		try {			
			return Base64.getDecoder().decode(imageString);
		} catch (Exception e) {
			throw new ImageConvertException();
		}
	}
	
}
