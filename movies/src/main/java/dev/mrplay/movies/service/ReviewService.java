package dev.mrplay.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev.mrplay.movies.model.Movie;
import dev.mrplay.movies.model.Review;
import dev.mrplay.movies.repository.ReviewRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Review createReview(String reviewBody, String imdbId) {
		
		Review review = reviewRepository.insert(new Review(reviewBody));
		
		log.info(review.toString());
		
		mongoTemplate.update(Movie.class)
						.matching(Criteria.where("imdbId").is(imdbId))
						.apply(new Update().push("reviewIds").value(review))
						.first();
		
		return review;
	}
	
}
