///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.csi.moviecatalog.config;
//
//import com.csi.moviecatalog.config.interceptor.RestTemplateInterceptor;
//import java.util.ArrayList;
//import java.util.List;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.client.ClientHttpRequestInterceptor;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
//import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
//import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
//import org.springframework.web.client.RestTemplate;
//
///**
// *
// * @author ratnesh
// */
//@Configuration
//public class BeanConfig {
//    
//    @Autowired
//    private  ClientRegistrationRepository clientRegistrationRepository;
//    @Autowired
//    private  OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;
//    
//    @Bean
//    public RestTemplate restTemplate(){
//        List<ClientHttpRequestInterceptor> interceptors=new ArrayList<>();
//        RestTemplate restTemplate = new RestTemplate();
//        interceptors.add(new RestTemplateInterceptor(manager(
//                clientRegistrationRepository,
//                oAuth2AuthorizedClientRepository
//        )));
//
//        restTemplate.setInterceptors(interceptors);
//        return restTemplate;
//    }
//    
//     @Bean
//    public OAuth2AuthorizedClientManager manager(
//            ClientRegistrationRepository clientRegistrationRepository,
//            OAuth2AuthorizedClientRepository auth2AuthorizedClientRepository
//    ) {
//        OAuth2AuthorizedClientProvider provider = OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials().build();
//        DefaultOAuth2AuthorizedClientManager defaultOAuth2AuthorizedClientManager = new DefaultOAuth2AuthorizedClientManager(clientRegistrationRepository, auth2AuthorizedClientRepository);
//        defaultOAuth2AuthorizedClientManager.setAuthorizedClientProvider(provider);
//        return defaultOAuth2AuthorizedClientManager;
//
//
//    }
//    
//}
