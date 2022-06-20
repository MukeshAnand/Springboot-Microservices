package com.microservices.moviecatalogservice.models;

import java.util.List;

public class UserRatings {

    List<Ratings> ratings;

    public UserRatings() {
    }

    public List<Ratings> getRatings() {
        return ratings;
    }

    public void setRatings(List<Ratings> ratings) {
        this.ratings = ratings;
    }
}
