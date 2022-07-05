package com.pragma.route.backend.image.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Image {

	private int resourceId;
	private int associationType;
	private String imageName;
	private String bodyBase64;
	
}