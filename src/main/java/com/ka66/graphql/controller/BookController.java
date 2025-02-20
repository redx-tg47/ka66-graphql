package com.ka66.graphql.controller;

import com.ka66.graphql.model.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {

  private final List<Book> books = new ArrayList<>(List.of(
      new Book(0L, "Effective Java", "Joshua Bloch"),
      new Book(1L, "Clean Code", "Robert C. Martin"),
      new Book(2L, "Spring in Action", "Craig Walls"),
      new Book(3L, "GraphQL for Beginners", "John Doe")
  ));

  @QueryMapping
  public List<Book> getBooks() {
    return books;
  }

  @QueryMapping
  public Book getBookById(@Argument Long id) {
    return books.stream()
        .filter(book -> book.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  @MutationMapping
  public Book addBook(@Argument String title, @Argument String author) {
    Book book = new Book((long) (books.size() + 1), title, author);
    books.add(book);
    return book;
  }

  @MutationMapping
  public Book updateBook(@Argument Long id, @Argument String title, @Argument String author) {
    for (Book book : books) {
      if (book.getId().equals(id)) {
        if (title != null) book.setTitle(title);
        if (author != null) book.setAuthor(author);
        return book;
      }
    }
    return null;
  }

  @MutationMapping
  public boolean deleteBook(@Argument Long id) {
    return books.removeIf(book -> book.getId().equals(id));
  }

}