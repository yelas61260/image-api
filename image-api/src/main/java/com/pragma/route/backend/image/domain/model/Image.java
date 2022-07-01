package com.pragma.route.backend.image.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Image {

	private int resourceId;
	private int associationType;
	private String imageName;
	private String bodyBase64;
	
}