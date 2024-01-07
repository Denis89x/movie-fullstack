package dev.lebenkov.movies.service;

import dev.lebenkov.movies.model.Review;

public interface ReviewService {
    Review createReview(String reviewBody, String imdbId);
}
