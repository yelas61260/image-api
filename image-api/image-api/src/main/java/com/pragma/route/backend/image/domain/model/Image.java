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

	private String imageId;
	private String imageName;
	private String bodyBase64;
	
	public Image clone() {
		return Image.builder()
				.imageId(imageId)
				.imageName(imageName)
				.bodyBase64(bodyBase64)
				.build();
	}
	
}