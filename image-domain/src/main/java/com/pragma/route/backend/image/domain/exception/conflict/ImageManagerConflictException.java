package com.pragma.route.backend.image.domain.exception.conflict;

import com.pragma.route.backend.image.domain.exception.ImageManagerException;

public class ImageManagerConflictException extends ImageManagerException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerConflictException(String message) {
		super(message);
	}

}
