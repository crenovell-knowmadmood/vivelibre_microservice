package com.vivelibre.vivelibre_microservice.config;

import com.vivelibre.vivelibre_microservice.comparators.BooksComparator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  public BooksComparator booksComparator() {
    return new BooksComparator();
  }
}
