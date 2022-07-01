package com.pragma.route.backend.image.domain.exception.conflict;

public class ImageManagerImageConvertException extends ImageManagerConflictException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerImageConvertException() {
		super("Image cant convert");
	}

}
