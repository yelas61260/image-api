package com.pragma.route.backend.image.infrastructure.db.mongo.normal.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pragma.route.backend.image.infrastructure.db.mongo.entity.ImageMongoEntity;

public interface ImageDao extends MongoRepository<ImageMongoEntity, String> {

}
