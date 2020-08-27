package com.teben.service;

import com.teben.models.Book;
import com.teben.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void insertBooks() {
        createBook(new Book("Silmarilion", "J. J. Tolkin"));
        createBook(new Book("1984", "George Orwell"));
        createBook(new Book("Three Comrades", "Erich Maria Remarque"));
        createBook(new Book("The Name of the Wind", "Patrick Rothfuss"));
    }

    public void createBook(Book book) {
        bookRepository.createBook(book);
    }

    public Book getBookById(Long bookId) {
        return bookRepository.getBookById(bookId);
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }
}
