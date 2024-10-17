package com.vivelibre.vivelibre_microservice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class BookDate {
  private Book book;
  private String date; // Fecha en formato mm-dd-yyyy

}