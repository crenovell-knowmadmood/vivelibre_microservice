package com.vivelibre.vivelibre_microservice.controller;

import com.vivelibre.vivelibre_microservice.entities.AuthTokenEntity;
import com.vivelibre.vivelibre_microservice.service.AuthServiceInterface;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenControllerImpl implements TokenController {

  public static final String DATETIME_FORMAT = "MMMM, dd, yyyy";
  @Autowired
  AuthServiceInterface authServiceInterface;

  @GetMapping("/get-token")
  public ResponseEntity<AuthTokenEntity> getToken() {
    final String token = authServiceInterface.getToken();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATETIME_FORMAT);
    final String date = LocalDate.now().format(formatter);//TODO Cambiar formato a February 21, 2018
    final String textDate = StringUtils.capitalize(date);
    AuthTokenEntity responseEntity = AuthTokenEntity.builder()
        .token(token)
        .date(textDate)
        .build();
    return new ResponseEntity<>(responseEntity, HttpStatus.OK);
  }

}
