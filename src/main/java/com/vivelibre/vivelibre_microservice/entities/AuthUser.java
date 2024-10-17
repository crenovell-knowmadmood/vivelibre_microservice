package com.vivelibre.vivelibre_microservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthUser {
  @JsonProperty("username")
  private String username;
  @JsonProperty("password")
  private String password;
}
