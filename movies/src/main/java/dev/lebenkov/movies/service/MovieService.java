package dev.lebenkov.movies.service;

import dev.lebenkov.movies.model.Movie;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> fetchAllMovies();

    Optional<Movie> fetchMovie(ObjectId id);

    Optional<Movie> fetchMovieByImdbId(String imdbId);
}
