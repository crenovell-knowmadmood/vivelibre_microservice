package com.vivelibre.vivelibre_microservice;

import com.vivelibre.vivelibre_microservice.entities.Book;
import java.time.LocalDate;

public class BooksTestUtils {

  /**
   * @param idStart
   * @param name
   * @param authorBiography
   * @param date
   * @return
   */
  protected static Book createBook(final long idStart, final String name, final String authorBiography,
      final String date) {

    final LocalDate publicationDate = LocalDate.parse(date);
    return Book.builder().id(idStart)
        .name(name)
        .summary("Summary of the book " + name)
        .authorBiography(authorBiography)
        .publicationDate(publicationDate)
        .build();
  }

}
