package com.transperfect.movies;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController()
@RequiredArgsConstructor
public class RecommendationsController {

    private final IRecommendationsService recommendationsService;

    @GetMapping("/recommendation")
    public ResponseEntity<List<Movie>> getRecommendations(@RequestParam String genre) {
        return new ResponseEntity<>(recommendationsService.getMoviesByGenre(genre), HttpStatus.OK);
    }
}
