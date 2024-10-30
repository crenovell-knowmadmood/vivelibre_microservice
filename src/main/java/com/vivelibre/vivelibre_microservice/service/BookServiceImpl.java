package com.vivelibre.vivelibre_microservice.service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.vivelibre.vivelibre_microservice.comparators.BooksComparator;
import com.vivelibre.vivelibre_microservice.entities.Book;
import com.vivelibre.vivelibre_microservice.entities.BookDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookServiceInterface {

  @Autowired
  BooksComparator comparator;
  @Override
  public Optional<BookDate> filter(String filter, List<Book> books) {

    books.stream()
        .filter(book -> isNull(book.getPublicationDate()))
        .forEach(book -> System.out.println("Libro con fecha: " + book.getName()));

    List<Book> filteredBooks = books.stream()
        .filter(book -> (nonNull(book.getName()) && book.getName().contains(filter)) ||
            (nonNull(book.getSummary()) && book.getSummary().contains(filter)) ||
            (nonNull(book.getAuthorBiography()) && book.getAuthorBiography().contains(filter)) && nonNull(
                book.getPublicationDate()))
        .sorted(comparator)
        .collect(Collectors.toList());

    if (filteredBooks.isEmpty()) {
      return Optional.empty();
    }

    Book mostRecentBook = filteredBooks.get(0);

    // Formatear la fecha al formato mm-dd-yyyy
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    String formattedDate = mostRecentBook.getPublicationDate().format(formatter);

    // Retornar el libro con el campo de fecha
    BookDate d = new BookDate(mostRecentBook, formattedDate);
    return Optional.of(d);

  }
}
