package com.pragma.route.backend.image.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.route.backend.image.application.mapper.ImageWithDtoMapper;
import com.pragma.route.backend.image.application.mapper.impl.ImageWithDtoMapperImpl;
import com.pragma.route.backend.image.application.service.impl.ImageConverterServiceImpl;
import com.pragma.route.backend.image.application.service.impl.ImageServiceImpl;
import com.pragma.route.backend.image.domain.service.ImageDomainService;
import com.pragma.route.backend.image.domain.service.util.ImageConverterDomainService;

@Configuration
public class BeanApplicationConfiguration {
	
	@Bean
	public ImageConverterServiceImpl imageConverterService(ImageConverterDomainService imageConverterDomainService) {
		return new ImageConverterServiceImpl(imageConverterDomainService);
	}
	
	@Bean
	public ImageServiceImpl imageService(ImageDomainService imageDomainService, ImageWithDtoMapper imageWithDtoMapper) {
		return new ImageServiceImpl(imageDomainService, imageWithDtoMapper);
	}
	
	@Bean
	public ImageWithDtoMapperImpl imageWithDtoMapper() {
		return new ImageWithDtoMapperImpl();
	}

}
