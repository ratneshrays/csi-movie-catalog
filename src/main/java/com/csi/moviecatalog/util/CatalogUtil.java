/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csi.moviecatalog.util;

/**
 *
 * @author ratnesh
 */
public class CatalogUtil {
    
    public static final String movieRatingServiceName = "csi-movie-rating";
    public static final String movieInfoServiceName = "csi-movie-info";
    public static final String movieRatingUrl = "http://"+movieRatingServiceName+"/api/v1/user/"; //http://localhost:9092/api/v1/user/
    public static final String movieInfoUrl = "http://"+movieInfoServiceName+"/api/v1/info/";  //http://localhost:9091/api/v1/info/
    public static final String movieDbInfoUrl = "http://"+movieInfoServiceName+"/api/v1/info/db/";  //http://localhost:9091/api/v1/info/db/
    public static final String eitt = "execution.isolation.thread.timeoutInMilliseconds";
    public static final String eis = "execution.isolation.strategy";
    public static final String cbr = "circuitBreaker.requestVolumeThreshold";
    public static final String cbe = "circuitBreaker.errorThresholdPercentage";
    public static final String cbs = "circuitBreaker.sleepWindowInMilliseconds";
    public static final String coreSize = "coreSize";
    public static final String maxQueueSize = "maxQueueSize";

}
