package com.vivelibre.vivelibre_microservice.controller;

import com.vivelibre.vivelibre_microservice.entities.AuthTokenEntity;
import com.vivelibre.vivelibre_microservice.service.AuthServiceInterface;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenControllerImpl implements TokenController {
  @Autowired
  AuthServiceInterface authServiceInterface;
  @GetMapping("/get-token")
  public ResponseEntity<AuthTokenEntity> getToken() {
    final String token = authServiceInterface.getToken();
    final String date = LocalDate.now().toString();
    AuthTokenEntity responseEntity = AuthTokenEntity.builder()
        .token(token)
        .date(date)
        .build();
    return new ResponseEntity<>(responseEntity, HttpStatus.OK);
  }

}
