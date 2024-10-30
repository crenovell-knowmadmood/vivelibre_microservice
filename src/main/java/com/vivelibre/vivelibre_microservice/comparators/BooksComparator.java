package com.vivelibre.vivelibre_microservice.comparators;

import com.vivelibre.vivelibre_microservice.entities.Book;
import java.util.Comparator;

public class BooksComparator implements Comparator<Book> {


  @Override
  public int compare(Book b1, Book b2) {
    int result = b1.getPublicationDate().compareTo(b2.getPublicationDate());
    if (result == 0) {
      result = b1.getAuthorBiography().compareTo(b2.getAuthorBiography());
    }

    return result;
  }
}
