package co.com.pragma.route.backend.image.model.image.exception.conflict;

import co.com.pragma.route.backend.image.model.image.exception.ApiException;

public class ApiConflictException extends ApiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ApiConflictException(String message) {
		super(message);
	}

}
