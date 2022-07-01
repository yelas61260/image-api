package com.pragma.route.backend.image.domain.service.util;

public interface ImageConverterDomainService {
	
	public String convertImageFileToBase64String(byte[] imageFile);
	public byte[] convertBase64StringToImageFile(String imageString);

}
