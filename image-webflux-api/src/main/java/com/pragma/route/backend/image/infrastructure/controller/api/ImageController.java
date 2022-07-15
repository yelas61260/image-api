package com.pragma.route.backend.image.infrastructure.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pragma.route.backend.image.application.dto.ImageDto;
import com.pragma.route.backend.image.infrastructure.service.ImageApiService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/image")
public class ImageController {

	private final ImageApiService imageApiService;

	@PostMapping("/create")
	public ResponseEntity<ImageDto> create(@RequestParam(value = "image", required = true) MultipartFile imageFile) {
		return new ResponseEntity<ImageDto>(imageApiService.create(imageFile), HttpStatus.OK);
	}

	@PutMapping("/{imageId}")
	public ResponseEntity<ImageDto> update(@PathVariable("imageId") String imageId, @RequestParam(value = "image", required = true) MultipartFile imageFile) {
		return new ResponseEntity<ImageDto>(imageApiService.update(imageId, imageFile), HttpStatus.OK);
	}

	@GetMapping("/{imageId}/base64")
	public @ResponseBody String getImageBase64(@PathVariable("imageId") String imageId) {
		return imageApiService.getImageBase64(imageId);
	}

	@GetMapping(value = "/{imageId}/file", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageFile(@PathVariable("imageId") String imageId) {
		return imageApiService.getImageFile(imageId);
	}
	
}
