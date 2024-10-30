package com.vivelibre.vivelibre_microservice.controller;

import com.vivelibre.vivelibre_microservice.entities.BookDate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface BookController {


  /**
   * @param text The filter by text
   * @return
   */
  ResponseEntity<BookDate> getBooks(@RequestParam("text") String text);
}
