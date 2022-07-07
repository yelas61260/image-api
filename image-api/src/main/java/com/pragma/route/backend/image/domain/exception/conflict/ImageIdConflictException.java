package com.pragma.route.backend.image.domain.exception.conflict;

public class ImageIdConflictException extends ApiConflictException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageIdConflictException() {
		super("Image ID need to be null");
	}

}
