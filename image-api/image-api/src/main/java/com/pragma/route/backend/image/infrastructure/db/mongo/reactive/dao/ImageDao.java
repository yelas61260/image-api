package com.pragma.route.backend.image.infrastructure.db.mongo.reactive.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.pragma.route.backend.image.infrastructure.db.mongo.entity.ImageMongoEntity;

public interface ImageDao extends ReactiveMongoRepository<ImageMongoEntity, String> {

}
