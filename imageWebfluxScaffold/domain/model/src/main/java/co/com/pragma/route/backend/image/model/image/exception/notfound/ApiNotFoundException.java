package co.com.pragma.route.backend.image.model.image.exception.notfound;

import co.com.pragma.route.backend.image.model.image.exception.ApiException;

public class ApiNotFoundException extends ApiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ApiNotFoundException(String message) {
		super(message);
	}

}
