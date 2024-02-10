/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csi.moviecatalog.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author ratnesh
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieInfo {
    
    String movieId;
    String movieName;
    String movieDescripation;
    String movieTagline;

    public MovieInfo() {
    }

    public MovieInfo(String movieId, String movieName, String movieDescripation, String movieTagline) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.movieDescripation = movieDescripation;
        this.movieTagline = movieTagline;
    }
    
    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescripation() {
        return movieDescripation;
    }

    public void setMovieDescripation(String movieDescripation) {
        this.movieDescripation = movieDescripation;
    }

    public String getMovieTagline() {
        return movieTagline;
    }

    public void setMovieTagline(String movieTagline) {
        this.movieTagline = movieTagline;
    }
}
