package com.pragma.route.backend.image.infrastructure.service.impl;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.pragma.route.backend.image.application.dto.ImageDTO;
import com.pragma.route.backend.image.application.service.ImageConverterService;
import com.pragma.route.backend.image.application.service.ImageService;
import com.pragma.route.backend.image.domain.exception.conflict.ImageManagerImageConvertException;
import com.pragma.route.backend.image.domain.exception.notfound.ImageManagerImageNotFoundException;
import com.pragma.route.backend.image.infrastructure.db.repository.ImageRepository;
import com.pragma.route.backend.image.infrastructure.service.ImageApiService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageApiServiceImpl implements ImageApiService {
	
	private final ImageService imageService;
	private final ImageConverterService imageConverterService;
	private final ImageRepository imageRepository;

	@Override
	public ImageDTO create(int associationType, int resourceId, MultipartFile imageFile) {
		ImageDTO imageDTO = null;
		try {
			imageDTO = imageService.prepareToCreate(associationType, resourceId, imageFile.getName(), imageFile.getBytes());
		} catch (IOException e) {
			throw new ImageManagerImageConvertException();
		} catch (NullPointerException e) {
			throw new ImageManagerImageConvertException();
		}
		return imageRepository.create(imageDTO);
	}

	@Override
	public ImageDTO update(int associationType, int resourceId, MultipartFile imageFile) {
		ImageDTO imageDTO = null;
		try {
			imageDTO = imageService.prepareToUpdate(associationType, resourceId, imageFile.getName(), imageFile.getBytes());
		} catch (IOException e) {
			throw new ImageManagerImageConvertException();
		} catch (NullPointerException e) {
			throw new ImageManagerImageConvertException();
		}
		return imageRepository.update(imageDTO);
	}

	@Override
	public String getImageBase64(int associationType, int resourceId) {
		ImageDTO imageDTO = imageService.getByAssociationTypeAndResourceId(associationType, resourceId);
		imageDTO = imageRepository.getById(imageDTO);
		if (imageDTO == null) {
			throw new ImageManagerImageNotFoundException();
		}
		return imageDTO.getImageBase64();
	}

	@Override
	public byte[] getImageFile(int associationType, int resourceId) {
		ImageDTO imageDTO = imageService.getByAssociationTypeAndResourceId(associationType, resourceId);
		imageDTO = imageRepository.getById(imageDTO);
		if (imageDTO == null) {
			throw new ImageManagerImageNotFoundException();
		}
		return imageConverterService.convertBase64StringToImageFile(imageDTO.getImageBase64());
	}

}