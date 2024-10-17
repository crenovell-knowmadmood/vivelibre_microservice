package com.vivelibre.vivelibre_microservice.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class AuthTokenEntityTest {

  @Test
  void test(){
    final String token = "token";
    final String date = LocalDateTime.now().toString();
    final AuthTokenEntity entity = AuthTokenEntity.builder()
        .token(token)
        .date(date)
        .build();
    assertEquals(token,entity.getToken());
    assertEquals(date,entity.getDate());

  }
}