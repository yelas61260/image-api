package com.pragma.route.backend.image.application.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ImageDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int resourceId;
	private int associationType;
	private String imageName;
	private String imageBase64;

}
