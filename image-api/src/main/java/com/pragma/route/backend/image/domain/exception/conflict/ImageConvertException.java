package com.pragma.route.backend.image.domain.exception.conflict;

public class ImageConvertException extends ApiConflictException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageConvertException() {
		super("Image cant convert");
	}

}
