package com.vivelibre.vivelibre_microservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthTokenEntity {

  @JsonProperty("auth-vivelibre-token")
  private String token;

  @JsonProperty("date")
  private String date;
}
