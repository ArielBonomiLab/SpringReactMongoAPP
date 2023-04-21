package dev.mrplay.movies.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="reviews")
public class Review {

	@Id
	private ObjectId id;
	private String body;
	
	public Review(String body) {
		this.body = body;
	}	
	
}
