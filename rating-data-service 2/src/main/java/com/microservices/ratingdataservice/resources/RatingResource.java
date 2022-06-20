package com.microservices.ratingdataservice.resources;


import com.microservices.ratingdataservice.models.Ratings;
import com.microservices.ratingdataservice.models.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/ratingsdata")
public class RatingResource {


    @RequestMapping("/{movieId}")
    public Ratings getRating(@PathVariable("movieId") String movieId){
        return new Ratings(movieId, 4);
    }

    @RequestMapping("users/{userId}")
    public UserRatings getUserRating(@PathVariable("userId") String userId){

        List<Ratings> ratings= Arrays.asList(new Ratings("123",4), new Ratings("500",3), new Ratings("300", 1));

       UserRatings userRating= new UserRatings();
       userRating.setRatings(ratings);

       return userRating;

    }
}
