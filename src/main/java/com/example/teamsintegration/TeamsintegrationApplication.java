package com.example.teamsintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TeamsintegrationApplication {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders getHttpHeaders() {
        return new HttpHeaders();
    }
    
    

    public static void main(String[] args) {
        SpringApplication.run(TeamsintegrationApplication.class, args);
    }

}
