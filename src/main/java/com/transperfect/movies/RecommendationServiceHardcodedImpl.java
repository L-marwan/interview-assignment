package com.transperfect.movies;

import java.util.Comparator;
import java.util.List;

public class RecommendationServiceHardcodedImpl implements IRecommendationsService {

    private final List<Movie> movies = List.of(new Movie(3l, "The Dark Knight", "Action", 2008, "Christopher Nolan"),
            new Movie(6l, "The Matrix", "Action", 1999, "The Wachowskis"));

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        return movies.stream()
                .filter(m -> genre.equalsIgnoreCase(m.genre()))
                .sorted(Comparator.comparing(Movie::releaseYear).reversed())
                .toList();
    }

}
