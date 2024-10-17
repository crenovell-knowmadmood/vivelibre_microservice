package com.vivelibre.vivelibre_microservice.controller;

import com.vivelibre.vivelibre_microservice.entities.AuthTokenEntity;
import org.springframework.http.ResponseEntity;

public interface TokenController {

  ResponseEntity<AuthTokenEntity> getToken();
}
