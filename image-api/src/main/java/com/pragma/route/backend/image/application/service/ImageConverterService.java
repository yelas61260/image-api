package com.pragma.route.backend.image.application.service;

public interface ImageConverterService {

	public String convertImageFileToBase64String(byte[] imageFile);
	public byte[] convertBase64StringToImageFile(String imageString);
	
}
