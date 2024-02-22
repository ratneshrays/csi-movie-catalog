/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csi.moviecatalog.services.impl;

import com.csi.moviecatalog.modal.MovieRating;
import com.csi.moviecatalog.modal.UserRatings;
import com.csi.moviecatalog.services.MovieRatingService;
import com.csi.moviecatalog.util.CatalogUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author ratnesh
 */
@Service
public class MovieRatingServiceImpl implements MovieRatingService{
    
    @Autowired
    RestTemplate restTemplate;
    
    @Override
    @HystrixCommand(fallbackMethod = "getFallbackUserRarings",
            commandProperties = {
            @HystrixProperty(name = CatalogUtil.eitt, value = "2000"),
            @HystrixProperty(name = CatalogUtil.eis, value = "THREAD"),
            @HystrixProperty(name = CatalogUtil.cbr, value = "6"),
            @HystrixProperty(name = CatalogUtil.cbe, value = "50"),
            @HystrixProperty(name = CatalogUtil.cbs, value = "10000")
            },
            threadPoolProperties = {
                @HystrixProperty(name = CatalogUtil.coreSize, value = "20"),
                @HystrixProperty(name = CatalogUtil.maxQueueSize, value = "10")
            })
    public UserRatings getUserRarings(String userId) {
        return restTemplate.getForObject(CatalogUtil.movieRatingUrl+userId, UserRatings.class);
    }
    
    @Override
    public UserRatings getFallbackUserRarings(String userId) {
        return null;
//        return new UserRatings(Arrays.asList(new MovieRating(userId, "NO Ratings Found")));
    }
}
