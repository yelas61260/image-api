package com.pragma.route.backend.image.domain.exception.notfound;

import com.pragma.route.backend.image.domain.exception.ApiException;

public class ApiNotFoundException extends ApiException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ApiNotFoundException(String message) {
		super(message);
	}

}
