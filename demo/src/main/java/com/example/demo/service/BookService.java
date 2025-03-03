package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();
    private Long nextId = 1L;

    public List<Book> getAllBooks() {
        return books;
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    public Book addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
        return book;
    }

    public boolean deleteBook(Long id) {
        return books.removeIf(book -> book.getId().equals(id));
    }
}
