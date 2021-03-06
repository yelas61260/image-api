package com.pragma.route.backend.image.infrastructure.response;

import java.sql.Timestamp;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class ResponseDTO {
	
	private Timestamp timestamp;
	private int respondeCode;
	private String status;
	private String description;
	
	public ResponseDTO(int respondeCode, String status, String description) {
		this.timestamp = new Timestamp(System.currentTimeMillis());
		this.respondeCode = respondeCode;
		this.status = status;
		this.description = description;
	}

}
