package com.vivelibre.vivelibre_microservice.comparators;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.vivelibre.vivelibre_microservice.BooksTestUtils;
import com.vivelibre.vivelibre_microservice.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BooksComparatorTest extends BooksTestUtils {

  BooksComparator comparator;

  @BeforeEach
  void setUp() {
    comparator = new BooksComparator();
  }

  @Test
  @DisplayName("When the date is the same, Then should be ordered by the author biography which has the shorter string")
  void compareByBiography() {
    int id = 1;
    final String date = "2024-10-24";
    final Book b1 = createBook(id, "El nuevo orden mundial", "Ray Dalio es un economista. Descripcion larga", date);
    final String expectedName = "Principios";
    final Book b2 = createBook(id, expectedName, "Ray Dalio es un economista", date);
    int result = comparator.compare(b1, b2);
    final String msg = String.format("The book should be named as: %s", b2.getName());

    assertEquals(19, result, msg);
  }


  @Test
  @DisplayName("When the date is NOT the same, Then should be returned a positive number because the second is chosen")
  void compareByDate() {
    int id = 1;
    final Book b1 = createBook(id, "El nuevo orden mundial", "Ray Dalio es un economista. Descripcion larga", "2024-10"
        + "-24");
    final String expectedName = "Principios";
    final Book b2 = createBook(id, expectedName, "Ray Dalio es un economista", "2024-10-23");
    int result = comparator.compare(b1, b2);
    final String msg = String.format("The book should be named as: %s", b2.getName());
    
    assertEquals(1, result, msg);
  }


  @Test
  @DisplayName("When the date and author biography is the same, Then should be returned zero")
  void compareByBothAndResultIsEqual() {
    int id = 1;
    final String date = "2024-10-24";
    final String authorBiography = "Ray Dalio es un economista";
    final String expectedName = "Principios";

    final Book b1 = createBook(id, "El nuevo orden mundial", authorBiography, date);
    final Book b2 = createBook(id, expectedName, authorBiography, date);

    int result = comparator.compare(b1, b2);

    assertEquals(0, result, "The books must have the same order");
  }

}