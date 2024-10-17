package com.vivelibre.vivelibre_microservice.controller;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vivelibre.vivelibre_microservice.entities.Book;
import com.vivelibre.vivelibre_microservice.entities.BookDate;
import com.vivelibre.vivelibre_microservice.service.BookServiceInterface;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControllerImpl implements BookController {

  @Autowired
  BookServiceInterface bookService;

  @GetMapping("/get-books")
  public ResponseEntity<BookDate> getBooks() {
    final List<Book> allBooks = loadBooksFromJson();
    final BookDate result = bookService.filter("Dalio", allBooks)
        .orElse(null);

    ResponseEntity<BookDate> response = new ResponseEntity<>(result, HttpStatus.OK);
    return response;
  }

  private List<Book> loadBooksFromJson() {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setSerializationInclusion(Include.ALWAYS);
    objectMapper.findAndRegisterModules();

    try (InputStream inputStream = getClass().getResourceAsStream("/books.json")) {
      return objectMapper.readValue(inputStream, new TypeReference<List<Book>>() {
      });
    } catch (IOException e) {
      throw new RuntimeException("Error al cargar los libros desde books.json", e);
    }
  }

}
