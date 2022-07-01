package com.pragma.route.backend.image.domain.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ImageResourceType {
	
	PERSON_IMAGE(1, "PI");
	private int id;
	private String prefix;
	
	public static ImageResourceType findByPrefix(String prefix) {
		for (ImageResourceType imageType : values()) {
			if (imageType.getPrefix().equals(prefix)) {
				return imageType;
			}
		}
		return null;
	}
	
	public static ImageResourceType findById(int id) {
		for (ImageResourceType imageType : values()) {
			if (imageType.getId() == id) {
				return imageType;
			}
		}
		return null;
	}
	
}