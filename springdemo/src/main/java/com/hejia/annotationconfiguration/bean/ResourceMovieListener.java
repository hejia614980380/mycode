package com.hejia.annotationconfiguration.bean;

import javax.annotation.Resource;

public class ResourceMovieListener {
    @Resource(name = "resourceMovieFinder")
    private ResourceMovieFinder movieFinder;

    public ResourceMovieListener() {
    }

    public ResourceMovieListener(ResourceMovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }

    public ResourceMovieFinder getMovieFinder() {
        return movieFinder;
    }

    public void setMovieFinder(ResourceMovieFinder movieFinder) {
        this.movieFinder = movieFinder;
    }
}
