package com.hejia.annotationconfiguration.bean;

import com.hejia.annotationconfiguration.annotation.MovieQualifier;
import com.hejia.annotationconfiguration.annotation.Offline;
import com.hejia.annotationconfiguration.enums.Format;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class QualifierMovieRecommender {

    @Autowired
//    @Qualifier("main")
    //  @Qualifier变式一
//    @Offline
    //  @Qualifier变式二
    @MovieQualifier(format = Format.VHS, genre = "Action")
    private QualifierMovieCatalog qualifierMovieCatalog;

    public QualifierMovieRecommender() {
    }

//    @Autowired
//    public QualifierMovieRecommender(@Qualifier("main") QualifierMovieCatalog qualifierMovieCatalog) {
    public QualifierMovieRecommender(QualifierMovieCatalog qualifierMovieCatalog) {
        this.qualifierMovieCatalog = qualifierMovieCatalog;
    }

    public QualifierMovieCatalog getQualifierMovieCatalog() {
        return qualifierMovieCatalog;
    }

    public void setQualifierMovieCatalog(QualifierMovieCatalog qualifierMovieCatalog) {
        this.qualifierMovieCatalog = qualifierMovieCatalog;
    }
}
