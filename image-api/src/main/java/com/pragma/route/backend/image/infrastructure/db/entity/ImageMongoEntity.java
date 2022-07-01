package com.pragma.route.backend.image.infrastructure.db.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document("imagerepo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImageMongoEntity {
	
	@Id
	private String id;
	
	private String imageName;
	private String bodyBase64;

}
