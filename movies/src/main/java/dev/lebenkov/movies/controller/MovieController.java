package dev.lebenkov.movies.controller;

import dev.lebenkov.movies.model.Movie;
import dev.lebenkov.movies.service.MovieService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.bson.types.ObjectId;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class MovieController {

    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> fetchAllMovies() {
        return new ResponseEntity<>(movieService.fetchAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> fetchMovie(@PathVariable ObjectId id) {
        return new ResponseEntity<>(movieService.fetchMovie(id).orElseThrow(() -> new RuntimeException("Movie does not exists!")), HttpStatus.OK);
    }

    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<Movie> fetchMovieByImdbId(@PathVariable String imdbId) {
        return new ResponseEntity<>(movieService.fetchMovieByImdbId(imdbId).orElseThrow(() -> new RuntimeException("Movie does not exists!")), HttpStatus.OK);
    }
}