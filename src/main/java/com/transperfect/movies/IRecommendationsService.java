package com.transperfect.movies;

import java.util.List;

public interface IRecommendationsService {

    /**
     * return a list of movies that belong to the specified genre, sorted by release
     * year in descending order.
     * 
     * @param genre
     * @return list of {@link Movie}
     */
    List<Movie> getMoviesByGenre(String genre);
}
