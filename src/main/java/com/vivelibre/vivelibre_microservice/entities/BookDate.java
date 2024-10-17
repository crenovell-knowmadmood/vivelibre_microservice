package com.vivelibre.vivelibre_microservice.entities;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookDate {

  private Book book;
  private String date; // Fecha en formato mm-dd-yyyy

}