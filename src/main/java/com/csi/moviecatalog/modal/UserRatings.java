/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csi.moviecatalog.modal;

import java.util.List;

/**
 *
 * @author ratnesh
 */
public class UserRatings {
    
    List<MovieRating> userMovieRatings;

    public UserRatings(List<MovieRating> userMovieRatings) {
        this.userMovieRatings = userMovieRatings;
    }

    public UserRatings() {
    }

    public List<MovieRating> getUserMovieRatings() {
        return userMovieRatings;
    }

    public void setUserMovieRatings(List<MovieRating> userMovieRatings) {
        this.userMovieRatings = userMovieRatings;
    }
    
}
