package dev.lebenkov.movies.repository;

import dev.lebenkov.movies.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReviewRepository extends MongoRepository<Review, String> {
}
