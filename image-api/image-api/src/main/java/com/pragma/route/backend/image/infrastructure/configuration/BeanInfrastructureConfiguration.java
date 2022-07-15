package com.pragma.route.backend.image.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pragma.route.backend.image.application.service.ImageConverterService;
import com.pragma.route.backend.image.application.service.ImageService;
import com.pragma.route.backend.image.infrastructure.db.mongo.normal.repository.ImageRepository;
import com.pragma.route.backend.image.infrastructure.service.impl.ImageApiServiceImpl;

@Configuration
public class BeanInfrastructureConfiguration {
	
	@Bean
	public ImageApiServiceImpl imageApiService(ImageService imageService, ImageConverterService imageConverterService, ImageRepository imageRepository) {
		return new ImageApiServiceImpl(imageService, imageConverterService, imageRepository);
	}

}
