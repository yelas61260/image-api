package com.pragma.route.backend.image.domain.exception.conflict;

public class ImageManagerResourceIdInvalidException extends ImageManagerConflictException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageManagerResourceIdInvalidException() {
		super("Invalid image ID");
	}

}
