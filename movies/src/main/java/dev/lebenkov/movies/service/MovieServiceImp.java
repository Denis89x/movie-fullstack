package dev.lebenkov.movies.service;

import dev.lebenkov.movies.model.Movie;
import dev.lebenkov.movies.repository.MovieRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MovieServiceImp implements MovieService {

    MovieRepository movieRepository;

    @Override
    public List<Movie> fetchAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public Optional<Movie> fetchMovie(ObjectId id) {
        return movieRepository.findById(id);
    }

    @Override
    public Optional<Movie> fetchMovieByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
