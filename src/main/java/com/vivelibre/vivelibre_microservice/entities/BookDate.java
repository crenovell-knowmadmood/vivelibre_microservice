package com.vivelibre.vivelibre_microservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookDate {
  @JsonProperty(required = true,value = "book")
  private Book book;
  @JsonProperty(required = false,value = "date")
  private String date; // Fecha en formato mm-dd-yyyy

}