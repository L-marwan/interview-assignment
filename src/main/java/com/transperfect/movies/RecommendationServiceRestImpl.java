package com.transperfect.movies;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecommendationServiceRestImpl implements IRecommendationsService {

    private final RestTemplate restTemplate;

    @Override
    public List<Movie> getMoviesByGenre(String genre) {
        log.debug(">> getMoviesByGenre({})", genre);
        try {
            Movie[] allMovies = restTemplate.getForObject(".../movies", Movie[].class);

            log.debug("movies service returned: {}", allMovies);

            return Arrays.stream(allMovies)
                    .filter(m -> genre.equalsIgnoreCase(m.genre()))
                    .sorted(Comparator.comparing(Movie::releaseYear).reversed())
                    .toList();

        } catch (Exception e) {
            throw new MoviesException("Error calling the movies api: " + e.getMessage());
        }
    }

}
