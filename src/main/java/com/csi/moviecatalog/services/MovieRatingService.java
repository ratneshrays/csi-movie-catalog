/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csi.moviecatalog.services;

import com.csi.moviecatalog.modal.UserRatings;

/**
 *
 * @author ratnesh
 */
public interface MovieRatingService {
    
    public UserRatings getUserRarings(String userId);
    
    public UserRatings getFallbackUserRarings(String userId);
}
