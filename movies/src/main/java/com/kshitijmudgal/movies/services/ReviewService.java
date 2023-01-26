package com.kshitijmudgal.movies.services;

import com.kshitijmudgal.movies.pojo.Movie;
import com.kshitijmudgal.movies.pojo.Review;
import com.kshitijmudgal.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review creatReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
        .matching(Criteria.where("imdbId").is(imdbId))
        .apply(new Update().push("reviewId").value(review))
        .first();

        return review;

    }
}
