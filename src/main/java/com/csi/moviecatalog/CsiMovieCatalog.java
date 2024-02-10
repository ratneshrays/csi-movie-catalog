/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.csi.moviecatalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

/**
 *
 * @author ratnesh
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class CsiMovieCatalog {

    public static void main(String[] args) {
        SpringApplication.run(CsiMovieCatalog.class, args);
    }
    
//    @Bean
//    public WebClient.Builder getWebClientBuilder(){
//        return WebClient.builder();
//    }
    
    @Bean
    public WebClient getWebClient(){
        return WebClient.builder().build();
    }
    
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){ //method name should be anythis it doesn't matter Return Type is matter
        return new RestTemplate();
    };
}
