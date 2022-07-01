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

import com.pragma.route.backend.image.infrastructure.response.ResponseDTO;
import com.pragma.route.backend.image.infrastructure.service.ImageApiService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/image")
public class ImageController {

	private final ImageApiService imageApiService;
	
	@PostMapping("/{associationType}/{resourceId}")
	public ResponseEntity<ResponseDTO> create(@PathVariable("associationType") int associationType, @PathVariable("resourceId") int resourceId,
			@RequestParam(value = "image", required = true) MultipartFile imageFile) {
		ResponseDTO response = new ResponseDTO(imageApiService.create(associationType, resourceId, imageFile), HttpStatus.OK.value(), "success");
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	@PutMapping("/{associationType}/{resourceId}")
	public ResponseEntity<ResponseDTO> update(@PathVariable("associationType") int associationType, @PathVariable("resourceId") int resourceId,
			@RequestParam(value = "image", required = true) MultipartFile imageFile) {
		ResponseDTO response = new ResponseDTO(imageApiService.update(associationType, resourceId, imageFile), HttpStatus.OK.value(), "success");
		return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
	}
	
	@GetMapping("/{associationType}/{resourceId}/base64")
	public @ResponseBody String getImageBase64(@PathVariable("associationType") int associationType, @PathVariable("resourceId") int resourceId) {
		return imageApiService.getImageBase64(associationType, resourceId);
	}
	
	@GetMapping(value = "/{associationType}/{resourceId}/file", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageFile(@PathVariable("associationType") int associationType, @PathVariable("resourceId") int resourceId) {
		return imageApiService.getImageFile(associationType, resourceId);
	}
	
}
