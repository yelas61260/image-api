package com.pragma.route.backend.image.domain.exception.conflict;

public class ResourceIdInvalidException extends ApiConflictException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ResourceIdInvalidException() {
		super("Invalid image ID");
	}

}
