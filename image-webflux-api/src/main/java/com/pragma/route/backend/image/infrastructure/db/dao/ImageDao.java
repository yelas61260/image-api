package com.pragma.route.backend.image.infrastructure.db.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.pragma.route.backend.image.infrastructure.db.entity.ImageMongoEntity;

public interface ImageDao extends ReactiveMongoRepository<ImageMongoEntity, String> {

}
