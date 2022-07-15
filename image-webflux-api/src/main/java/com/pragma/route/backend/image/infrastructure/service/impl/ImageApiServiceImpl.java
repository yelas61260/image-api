package com.pragma.route.backend.image.infrastructure.service.impl;

import org.springframework.web.multipart.MultipartFile;

import com.pragma.route.backend.image.application.dto.ImageDto;
import com.pragma.route.backend.image.application.service.ImageConverterService;
import com.pragma.route.backend.image.application.service.ImageService;
import com.pragma.route.backend.image.domain.exception.conflict.ImageConvertException;
import com.pragma.route.backend.image.domain.exception.conflict.ImageIdRequiredException;
import com.pragma.route.backend.image.domain.exception.notfound.ImageNotFoundException;
import com.pragma.route.backend.image.infrastructure.db.repository.ImageRepository;
import com.pragma.route.backend.image.infrastructure.service.ImageApiService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ImageApiServiceImpl implements ImageApiService {
	
	private final ImageService imageService;
	private final ImageConverterService imageConverterService;
	private final ImageRepository imageRepository;

	@Override
	public ImageDto create(MultipartFile imageFile) {
		ImageDto imageDTO = null;
		try {
			imageDTO = ImageDto.builder()
					.imageName(imageFile.getOriginalFilename())
					.build();
			imageDTO = imageService.prepareToCreate(imageDTO, imageFile.getBytes());
		} catch (Exception e) {
			throw new ImageConvertException();
		}
		return imageRepository.create(imageDTO);
	}

	@Override
	public ImageDto update(String imageId, MultipartFile imageFile) {
		ImageDto imageDTO = null;
		try {
			imageDTO = ImageDto.builder()
					.imageId(imageId)
					.imageName(imageFile.getOriginalFilename())
					.build();
			imageDTO = imageService.prepareToUpdate(imageDTO, imageFile.getBytes());
		} catch (ImageIdRequiredException e) {
			throw new ImageIdRequiredException();
		} catch (Exception e) {
			throw new ImageConvertException();
		}
		ImageDto imageDtoSearch = imageRepository.getById(imageId);
		if (imageDtoSearch == null) {
			throw new ImageNotFoundException();
		}
		
		return imageRepository.update(imageDTO);
	}

	@Override
	public String getImageBase64(String imageId) {
		ImageDto imageDTO = imageRepository.getById(imageId);
		if (imageDTO == null) {
			throw new ImageNotFoundException();
		}
		imageDTO = imageService.getById(imageDTO);
		return imageDTO.getImageBase64();
	}

	@Override
	public byte[] getImageFile(String imageId) {
		ImageDto imageDTO = imageRepository.getById(imageId);
		if (imageDTO == null) {
			throw new ImageNotFoundException();
		}
		imageDTO = imageService.getById(imageDTO);
		return imageConverterService.convertBase64StringToImageFile(imageDTO.getImageBase64());
	}

}
