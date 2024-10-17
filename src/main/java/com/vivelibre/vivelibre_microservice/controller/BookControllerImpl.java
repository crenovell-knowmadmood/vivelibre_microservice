package com.vivelibre.vivelibre_microservice.controller;

import com.vivelibre.vivelibre_microservice.entities.Book;
import com.vivelibre.vivelibre_microservice.entities.BookDate;
import com.vivelibre.vivelibre_microservice.service.BookServiceInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControllerImpl implements BookController {

  @Autowired
  BookServiceInterface bookService;

  @GetMapping("/get-token")
  public ResponseEntity<BookDate> getBooks() {
    Long idBook = 1l;
    List<Book> allBooks = List.of(
        Book.builder().id(idBook++).name("Libro1").build(),
        Book.builder().id(idBook++).name("Libro1").build(),
        Book.builder().id(idBook).name("Libro1").build()
    );
    BookDate result = bookService.filter("", allBooks)
        .orElse(null);

    ResponseEntity<BookDate> response = new ResponseEntity<>(result, HttpStatus.OK);
    return response;
  }

}
