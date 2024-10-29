package com.vivelibre.vivelibre_microservice.service;

import com.vivelibre.vivelibre_microservice.entities.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class AuthServiceImpl implements AuthService {

  @Value("${AUTH_SERVICE_URL:http://localhost:8081/token}")
  private String authServiceUrl;
  @Autowired
  RestTemplate restTemplate;

  @Override
  public String getToken() {
    final String url = authServiceUrl;
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    final String username = "auth-vivelibre";
    final String password = "password";
    final AuthUser entity = AuthUser.builder()
        .username(username)
        .password(password)
        .build();
    final HttpEntity<AuthUser> httpEntity = new HttpEntity<>(entity);
    final ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
    return response.getBody();
  }
}
