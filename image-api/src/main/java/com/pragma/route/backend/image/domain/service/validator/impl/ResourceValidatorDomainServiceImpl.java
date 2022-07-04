package com.pragma.route.backend.image.domain.service.validator.impl;

import com.pragma.route.backend.image.domain.constant.ImageResourceType;
import com.pragma.route.backend.image.domain.exception.notfound.ResourceTypeNotFoundException;
import com.pragma.route.backend.image.domain.service.validator.ResourceValidatorDomainService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResourceValidatorDomainServiceImpl implements ResourceValidatorDomainService {

	@Override
	public void validateResourceTypeById(int resourceId) {
		ImageResourceType resourceType = 
				ImageResourceType.findById(resourceId);
		if (resourceType == null) {
			throw new ResourceTypeNotFoundException();
		}
	}

}
