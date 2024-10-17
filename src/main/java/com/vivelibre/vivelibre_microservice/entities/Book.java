package com.vivelibre.vivelibre_microservice.entities;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Book {

  private Long id;
  private String name;
  private String summary;
  private String authorBiography;
  private LocalDate publicationDate;
}


