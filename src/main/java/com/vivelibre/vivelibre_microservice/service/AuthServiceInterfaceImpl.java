package com.vivelibre.vivelibre_microservice.service;

import com.vivelibre.vivelibre_microservice.entities.AuthUser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class AuthServiceInterfaceImpl implements AuthServiceInterface {

  @Override
  public String getToken() {
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8080/token";
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    final AuthUser entity = AuthUser.builder()
        .username("auth-vivelibre")
        .password("password")
        .build();
    HttpEntity<AuthUser> httpEntity = new HttpEntity<>(entity);
    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
    return response.getBody();
  }
}
