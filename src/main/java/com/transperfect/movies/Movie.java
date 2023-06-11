package com.transperfect.movies;

/**
 * Model for the movie
 * 
 */
public record Movie(Long id,
        String title,
        String genre,
        int releaseYear,
        String director) {

}
