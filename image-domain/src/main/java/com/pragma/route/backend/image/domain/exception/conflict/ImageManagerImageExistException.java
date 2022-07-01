package com.pragma.route.backend.image.domain.exception.conflict;

public class ImageManagerImageExistException extends ImageManagerConflictException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerImageExistException() {
		super("Image id exist");
	}

}
