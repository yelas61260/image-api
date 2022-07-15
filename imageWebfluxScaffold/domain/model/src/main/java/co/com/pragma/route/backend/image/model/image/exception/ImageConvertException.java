package co.com.pragma.route.backend.image.model.image.exception;

import co.com.pragma.route.backend.image.model.image.exception.conflict.ApiConflictException;

public class ImageConvertException extends ApiConflictException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ImageConvertException() {
		super("Image cant convert");
	}

}
