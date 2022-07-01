package com.pragma.route.backend.image.infrastructure.db.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pragma.route.backend.image.infrastructure.db.entity.ImageMongoEntity;

public interface ImageDao extends MongoRepository<ImageMongoEntity, String> {

}
