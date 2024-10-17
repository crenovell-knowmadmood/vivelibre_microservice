package com.vivelibre.vivelibre_microservice.controller;

import com.vivelibre.vivelibre_microservice.entities.Book;
import com.vivelibre.vivelibre_microservice.entities.BookDate;
import org.springframework.http.ResponseEntity;

public interface BookController {
  ResponseEntity<BookDate> getBooks();
}
