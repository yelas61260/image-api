package com.pragma.route.backend.image.domain.exception.notfound;

import com.pragma.route.backend.image.domain.exception.ImageManagerException;

public class ImageManagerNotFoundException extends ImageManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerNotFoundException(String message) {
		super(message);
	}

}
