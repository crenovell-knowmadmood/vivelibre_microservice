package com.vivelibre.vivelibre_microservice.controller;

import com.vivelibre.vivelibre_microservice.entities.BookDate;
import org.springframework.http.ResponseEntity;

public interface BookController {

  /**
   * Gets the books filtered.
   * @return
   */
  ResponseEntity<BookDate> getBooks();
}
