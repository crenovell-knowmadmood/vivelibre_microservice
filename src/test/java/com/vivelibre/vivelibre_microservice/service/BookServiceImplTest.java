package com.vivelibre.vivelibre_microservice.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.vivelibre.vivelibre_microservice.BooksTestUtils;
import com.vivelibre.vivelibre_microservice.entities.Book;
import com.vivelibre.vivelibre_microservice.entities.BookDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class BookServiceImplTest extends BooksTestUtils {

  @Autowired
  BookServiceImpl service;


  @Test
  void testFilter() {
    final String filterSearch = "Prueba";

    long idStart = 1l;
    final List<Book> books = List.of(
        createBook(idStart, "Ray Dalio", "Biografia de Ray Dalio", "2024-10-10"),
        createBook(++idStart, "Prueba", "Biografia de Peter Lynch", "2024-09-20"),
        createBook(++idStart, "Prueba 2", "Biografia de Peter", "2024-08-10"),
        createBook(++idStart, "Otra Prueba", "", "2024-01-22")
    );
    final Optional<BookDate> filteredBookDate = service.filter(filterSearch, books);
    assertNotNull(filteredBookDate);
    //assertNotNull(filteredBookDate);
  }

}