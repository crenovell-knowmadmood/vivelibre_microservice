package com.vivelibre.vivelibre_microservice.service;

import com.vivelibre.vivelibre_microservice.entities.Book;
import com.vivelibre.vivelibre_microservice.entities.BookDate;
import java.util.List;
import java.util.Optional;

public interface BookServiceInterface {

  Optional<BookDate> filter(String filter, List<Book> books);
}
