package com.pragma.route.backend.image.domain.exception.notfound;

public class ImageManagerResourceTypeNotFoundException extends ImageManagerNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerResourceTypeNotFoundException() {
		super("Invalid resource prefix");
	}

}
