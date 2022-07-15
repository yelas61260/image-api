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
import com.pragma.route.backend.image.infrastructure.response.ResponseDTO;
import com.pragma.route.backend.image.infrastructure.service.ImageApiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/image")
public class ImageController {

	private final ImageApiService imageApiService;
	
	@Operation(summary = "Almacenar una imagen")
    @ApiResponse(responseCode = "200", description = "Imagen almacenada con exito")
    @ApiResponse(responseCode = "409", description = "Existe un conflicto en la peticion",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
    @ApiResponse(responseCode = "500", description = "Ocurrio un error inesperado",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
	@PostMapping("/create")
	public ResponseEntity<ImageDto> create(@RequestParam(value = "image", required = true) MultipartFile imageFile) {
		return new ResponseEntity<ImageDto>(imageApiService.create(imageFile), HttpStatus.OK);
	}
	
	@Operation(summary = "Actualizar una imagen")
    @ApiResponse(responseCode = "200", description = "Imagen actualizada con exito")
    @ApiResponse(responseCode = "409", description = "Existe un conflicto en la peticion",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
    @ApiResponse(responseCode = "404", description = "Se mando la peticion con un recurso que no existe",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
    @ApiResponse(responseCode = "500", description = "Ocurrio un error inesperado",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
	@PutMapping("/{imageId}")
	public ResponseEntity<ImageDto> update(@PathVariable("imageId") String imageId, @RequestParam(value = "image", required = true) MultipartFile imageFile) {
		return new ResponseEntity<ImageDto>(imageApiService.update(imageId, imageFile), HttpStatus.OK);
	}
	
	@Operation(summary = "Solicitar una imagen en base 64 asociada a un recurso indicando el identificador del tipo de recurso y el id del recurso")
    @ApiResponse(responseCode = "200", description = "Solicitud exitosa")
    @ApiResponse(responseCode = "404", description = "El recurso solicitado no existe",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
    @ApiResponse(responseCode = "500", description = "Ocurrio un error inesperado",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
	@GetMapping("/{imageId}/base64")
	public @ResponseBody String getImageBase64(@PathVariable("imageId") String imageId) {
		return imageApiService.getImageBase64(imageId);
	}
	
	@Operation(summary = "Solicitar una archivo de imagen asociada a un recurso indicando el identificador del tipo de recurso y el id del recurso")
    @ApiResponse(responseCode = "200", description = "Solicitud exitosa")
    @ApiResponse(responseCode = "404", description = "El recurso solicitado no existe",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
    @ApiResponse(responseCode = "500", description = "Ocurrio un error inesperado",
    		content = {
    				@Content(mediaType = "application/json" , schema = @Schema(implementation = ResponseDTO.class))
    		})
	@GetMapping(value = "/{imageId}/file", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageFile(@PathVariable("imageId") String imageId) {
		return imageApiService.getImageFile(imageId);
	}
	
}
