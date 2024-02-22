/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.csi.moviecatalog.services;

import com.csi.moviecatalog.modal.MovieInfo;
import com.csi.moviecatalog.modal.MovieRating;

/**
 *
 * @author ratnesh
 */
public interface MovieInfoService {
    
    public MovieInfo getMovieInfo(MovieRating movieRating);
    
    public MovieInfo getFallbackMovieInfo(MovieRating movieRating);
}
