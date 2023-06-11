package com.transperfect.movies;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class RecommendationServiceRestImplTest {

    @Mock
    RestTemplate restTemplate;
    @InjectMocks
    RecommendationServiceRestImpl serviceToTest;

    private String moviesResult = """
                        [{
            "id": 1,
            "title": "The Shawshank Redemption",
            "genre": "Drama",
            "releaseYear": 1994,
            "director": "Frank Darabont"
            },
            {
            "id": 2,
            "title": "The Godfather",
            "genre": "Drama",
            "releaseYear": 1972,
            "director": "Francis Ford Coppola"
            },
            {
            "id": 6,
            "title": "The Matrix",
            "genre": "Action",
            "releaseYear": 1999,
            "director": "The Wachowskis"
            },
            {
            "id": 3,
            "title": "The Dark Knight",
            "genre": "Action",
            "releaseYear": 2008,
            "director": "Christopher Nolan"
            }]""";

    @Test
    void givenValidGenreShouldReturnSortedResult() throws Exception {
        
        when(restTemplate.getForObject(".../movies", Movie[].class)).thenReturn(new ObjectMapper().readValue(moviesResult, Movie[].class));
        var expected = List.of(new Movie(3l, "The Dark Knight", "Action", 2008, "Christopher Nolan"),
                new Movie(6l, "The Matrix", "Action", 1999, "The Wachowskis"));
        
        assertIterableEquals(expected, serviceToTest.getMoviesByGenre("action"));
    }

}
