package dev.lebenkov.movies.service;

import dev.lebenkov.movies.model.Movie;
import dev.lebenkov.movies.model.Review;
import dev.lebenkov.movies.repository.ReviewRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ReviewServiceImp implements ReviewService {

    ReviewRepository reviewRepository;

    MongoTemplate mongoTemplate;

    @Override
    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(Review.builder()
                .body(reviewBody)
                .build());

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("review").value(review))
                .first();

        return review;
    }
}
