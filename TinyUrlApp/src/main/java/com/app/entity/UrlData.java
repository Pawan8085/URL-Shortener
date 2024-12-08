package com.app.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UrlData {
	
	@Id
	private String shortUrl;
	private String originalUrl;
	
	
}
