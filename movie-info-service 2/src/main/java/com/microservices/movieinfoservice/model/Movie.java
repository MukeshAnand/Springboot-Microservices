package com.microservices.movieinfoservice.model;

public class Movie {

    String movieId;
    String name;
    String desc;

    public Movie(String movieId, String name, String desc) {
        this.movieId = movieId;
        this.name = name;
        this.desc = desc;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
