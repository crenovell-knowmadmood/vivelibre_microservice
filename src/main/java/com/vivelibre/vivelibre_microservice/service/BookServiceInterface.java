package com.vivelibre.vivelibre_microservice.service;

import com.vivelibre.vivelibre_microservice.entities.Book;
import com.vivelibre.vivelibre_microservice.entities.BookDate;
import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {

  /**
   * Search for a string in any of the fields and gets the date of the most recent book.
   * @param filter
   * @param books
   * @return
   */
  Optional<BookDate> filter(String filter, List<Book> books);
}
