package com.pragma.route.backend.image.domain.exception.conflict;

public class ImageIdRequiredException extends ApiConflictException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageIdRequiredException() {
		super("Image ID is required");
	}

}
