package com.pragma.route.backend.image.domain.exception.conflict;

public class ImageExistException extends ApiConflictException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageExistException() {
		super("Image id exist");
	}

}
