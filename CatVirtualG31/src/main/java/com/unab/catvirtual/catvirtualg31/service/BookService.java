package com.unab.catvirtual.catvirtualg31.service;

import com.unab.catvirtual.catvirtualg31.entity.Book;
import com.unab.catvirtual.catvirtualg31.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> listBooks(){
        return bookRepository.findAll();
    }

    public Book addBook(Book book){

        Book oneBook;
        Optional<Book> optional = bookRepository.findById(book.getIsbn());

        if (!optional.isEmpty()) return null;
        else return bookRepository.insert(book);
    }

    public void deleteBook(String isbn){
        bookRepository.deleteById(isbn);
    }

    public List<Book> listBooksByCategory(String categoryName){
        return bookRepository.findByCategory(categoryName);
    }

    public List<Book> listBooksByAuthor(String authorName){
        return bookRepository.findByAuthor(authorName);
    }

    public Book findByIsbn(String isbn){
        Book book;
        Optional<Book> optional = bookRepository.findById(isbn);

        if (!optional.isEmpty())
            book = optional.get();
        else book=null;

        return book;
    }

    public List<Book> listBooksByLetter(String letter){
        return bookRepository.findByTitleStartsWith(letter);
    }
}
