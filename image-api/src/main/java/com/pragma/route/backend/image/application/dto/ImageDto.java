package com.pragma.route.backend.image.application.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String imageId;
	
	@NotBlank
	private String imageName;
	
	@NotBlank
	private String imageBase64;

}
