package com.pragma.route.backend.image.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.route.backend.image.domain.service.impl.ImageDomainServiceImpl;
import com.pragma.route.backend.image.domain.service.util.ImageConverterDomainService;
import com.pragma.route.backend.image.domain.service.util.impl.ImageConverterDomainServiceImpl;
import com.pragma.route.backend.image.domain.service.validator.ImageValidatorDomainService;
import com.pragma.route.backend.image.domain.service.validator.impl.ImageValidatorDomainServiceImpl;

@Configuration
public class BeanDomainConfiguration {
	
	@Bean
	public ImageDomainServiceImpl imageDomainService(ImageValidatorDomainService imageValidatorService, ImageConverterDomainService imageConverterDomainService) {
		return new ImageDomainServiceImpl(imageValidatorService, imageConverterDomainService);
	}
	
	@Bean
	public ImageConverterDomainServiceImpl imageConverterDomainService() {
		return new ImageConverterDomainServiceImpl();
	}
	
	@Bean
	public ImageValidatorDomainServiceImpl imageValidatorDomainService() {
		return new ImageValidatorDomainServiceImpl();
	}

}
