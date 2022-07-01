package com.pragma.route.backend.image.domain.exception.notfound;

public class ImageManagerImageNotFoundException extends ImageManagerNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ImageManagerImageNotFoundException() {
		super("Image not found");
	}

}
