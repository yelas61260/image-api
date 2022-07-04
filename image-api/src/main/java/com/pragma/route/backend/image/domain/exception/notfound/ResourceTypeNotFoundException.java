package com.pragma.route.backend.image.domain.exception.notfound;

public class ResourceTypeNotFoundException extends ApiNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceTypeNotFoundException() {
		super("Invalid resource prefix");
	}

}
