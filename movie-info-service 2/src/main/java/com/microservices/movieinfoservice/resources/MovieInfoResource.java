package com.microservices.movieinfoservice.resources;


import com.microservices.movieinfoservice.model.Movie;
import com.microservices.movieinfoservice.model.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
    @Autowired
    RestTemplate restTemplate;

    @Value("${api.key}")
    String apiKey;


    @RequestMapping("/{movieId}")
    public Movie getMovie(@PathVariable("movieId") String movieId){

        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"+movieId+"?api_key="+apiKey, MovieSummary.class);

        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
    }
}
