package com.hejia.annotationconfiguration.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

public class MovieRecommender {
//    @Autowired(required = false)
    @Autowired
    private MovieCatalog movieCatalog;

//    @Autowired(required = false)
    @Autowired
    private List<MovieCatalog> movieCatalogs;

    @Autowired
    private Optional<MovieCatalog> movieCatalogOption;

    @Autowired
    private ApplicationContext applicationContext;

    public MovieRecommender() {
    }

    //    @Autowired
    public MovieRecommender(MovieCatalog movieCatalog, List<MovieCatalog> movieCatalogs, Optional<MovieCatalog> movieCatalogOption, ApplicationContext applicationContext) {
        this.movieCatalog = movieCatalog;
        this.movieCatalogs = movieCatalogs;
        this.movieCatalogOption = movieCatalogOption;
        this.applicationContext = applicationContext;
    }

    public MovieRecommender(MovieCatalog movieCatalog) {
        this.movieCatalog = movieCatalog;
    }

    public MovieCatalog getMovieCatalog() {
        return movieCatalog;
    }

//    @Autowired
    public void setMovieCatalog(MovieCatalog movieCatalog) {
        this.movieCatalog = movieCatalog;
    }

    public List<MovieCatalog> getMovieCatalogs() {
        return movieCatalogs;
    }

    public void setMovieCatalogs(List<MovieCatalog> movieCatalogs) {
        this.movieCatalogs = movieCatalogs;
    }

    public Optional<MovieCatalog> getMovieCatalogOption() {
        return movieCatalogOption;
    }

    public void setMovieCatalogOption(Optional<MovieCatalog> movieCatalogOption) {
        this.movieCatalogOption = movieCatalogOption;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
