package com.vivelibre.vivelibre_microservice.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AuthUserTest {

  @Test
  void test() {
    final String username = "username";
    final String password = "pass";
    final AuthUser entity = AuthUser.builder().username(username).password(password).build();
    assertEquals(username, entity.getUsername());
    assertEquals(password, entity.getPassword());
  }
}