package com.microservices.moviecatalogservice.resource;

import com.microservices.moviecatalogservice.models.CatalogItem;
import com.microservices.moviecatalogservice.models.Movie;
import com.microservices.moviecatalogservice.models.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieResource {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

//    @Autowired
//    WebClient.Builder builder;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){

        //Get all rated Movie Id
        UserRatings userRatings= restTemplate.getForObject("http://rating-data-service/ratingsdata/users/"+userId, UserRatings.class);

        return  userRatings.getRatings().stream().map(ratings -> {
            // For Each Movie Id ,call Movie info get Movie Details
           Movie movie=restTemplate.getForObject("http://movie-info-service/movies/"+ratings.getMovieId(), Movie.class);
          //consolidate together
            return new CatalogItem(movie.getName(), movie.getDesc(),ratings.getRating());
        }).collect(Collectors.toList());

       // return Collections.singletonList( new CatalogItem("PudhuPettai","A Rise of Gangster "+userId, 5));
    }
    /*  Movie movie=builder.build()
                    .get()
                    .uri("http://localhost:8082/movies/"+ratings.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

   */
}
