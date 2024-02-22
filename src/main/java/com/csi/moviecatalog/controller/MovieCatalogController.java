/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csi.moviecatalog.controller;

import com.csi.moviecatalog.modal.MovieCatalog;
import com.csi.moviecatalog.modal.MovieInfo;
import com.csi.moviecatalog.modal.MovieRating;
import com.csi.moviecatalog.modal.UserRatings;
import com.csi.moviecatalog.props.DataSource;
import com.csi.moviecatalog.props.Greeting;
import com.csi.moviecatalog.services.MovieInfoService;
import com.csi.moviecatalog.services.MovieRatingService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author ratnesh
 */
@RestController
@RefreshScope
@RequestMapping("/api/v1")
public class MovieCatalogController {
    
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Autowired
//    private WebClient webClient;
    
    @Autowired
    private MovieInfoService movieInfoService;
    
    @Autowired
    private MovieRatingService movieRatingService;
    
//    @Autowired
//    private DiscoveryClient discoveryClient;
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private Greeting greeting;
      
    @GetMapping("/props/greeting")
    public List<String> getGreetingProps() {
        List<String> dataList = new ArrayList<>();
        dataList.add(greeting.getId());
        dataList.add(greeting.getName());
        dataList.add(greeting.getDescription());
        dataList.add(greeting.getMessage());
        return dataList;
    }
    
    @GetMapping("/props/datasource")
    public List<String> getDataSourceProps() {
        List<String> dataList = new ArrayList<>();
        dataList.add(dataSource.getUrl());
        dataList.add(dataSource.getUsername());
        dataList.add(dataSource.getPassword());
        return dataList;
    }
    
    @RequestMapping("/catalog/{userId}")
    public List<MovieCatalog> getMovieCatalogs(@PathVariable("userId") String userId) {
        return Collections.singletonList(
        new MovieCatalog("1", "PK", "alien movie", "unknown", "4")
        ); 
    }

    @RequestMapping("/deatiledCatalog/{userId}")
//    @HystrixCommand(fallbackMethod = "getFallBackMovieCatalogswithDetails") //this is the worst case because both api are coved in single fallback
    public List<MovieCatalog> getMovieCatalogswithDetails(@PathVariable("userId") String userId) {
        List<MovieCatalog> movieCatalogs = new ArrayList<>();
//        List<MovieRating> ratings = Arrays.asList(
//        new MovieRating("101", "4"),
//        new MovieRating("102", "3")
//        );
        UserRatings userRatings = movieRatingService.getUserRarings(userId);
        List<MovieRating> ratings = userRatings.getUserMovieRatings();
//        //3.
//        for(MovieRating movieRating : ratings){
//            MovieInfo movieInfo = webClient
//                    .get()
//                    .uri(movieInfoUrl+movieRating.getMovieId())
//                    .retrieve()
//                    .bodyToMono(MovieInfo.class)
//                    .block();
//            movieCatalogs.add(new MovieCatalog(movieInfo.getMovieId(), movieInfo.getMovieName(), "", movieRating.getRating()));
//        }
//        return movieCatalogs;      
//        //2.
        for(MovieRating movieRating : ratings){
            MovieInfo movieInfo = movieInfoService.getMovieInfo(movieRating);
            MovieCatalog catalog = new MovieCatalog(movieInfo.getMovieId(), movieInfo.getMovieName(), movieInfo.getMovieDescripation(),
                    movieInfo.getMovieTagline(), movieRating.getRating());
            movieCatalogs.add(catalog);
        }
        return movieCatalogs;
//        //1.
//        return ratings.stream().map(rating -> 
//                new MovieCatalog("101", "PK", "alien movie", rating.getRating())
//                )
//                .collect(Collectors.toList());
    }
    public List<MovieCatalog> getFallBackMovieCatalogswithDetails(@PathVariable("userId") String userId) {
        return Arrays.asList(new MovieCatalog("0", "No Movie Found", "", "", ""));

    }
   
}
