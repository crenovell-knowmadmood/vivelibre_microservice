package com.vivelibre.vivelibre_microservice.controller;

import com.vivelibre.vivelibre_microservice.entities.Book;
import org.springframework.http.ResponseEntity;

public interface BookController {
  ResponseEntity<Book> getBooks();
}
