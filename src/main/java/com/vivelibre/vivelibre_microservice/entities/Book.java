package com.vivelibre.vivelibre_microservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Book {

  @JsonProperty(value = "id", required = true)
  private Long id;

  @JsonProperty(value = "name", required = true)
  private String name;

  @JsonProperty("summary")
  private String summary;

  @JsonProperty("authorBiography")
  private String authorBiography;

  @JsonProperty("publicationDate")
  private LocalDate publicationDate;
}


