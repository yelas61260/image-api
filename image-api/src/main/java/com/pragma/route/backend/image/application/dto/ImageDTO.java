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
public class ImageDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private int resourceId;
	
	@NotBlank
	private int associationType;
	
	@NotBlank
	private String imageName;
	
	@NotBlank
	private String imageBase64;

}
