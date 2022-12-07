package com.unab.catvirtual.catvirtualg31.controller;

import com.unab.catvirtual.catvirtualg31.entity.Book;
import com.unab.catvirtual.catvirtualg31.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/new")
    public Book addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }

    @GetMapping("/all")
    public List<Book> listBooks(){
        return bookService.listBooks();
    }

    @GetMapping("/category/{catName}")
    public List<Book> listBooksByCategory(@PathVariable("catName") String categoryName){
        return bookService.listBooksByCategory(categoryName);
    }

    @GetMapping("/author/{author}")
    public List<Book> listBooksByAuthor(@PathVariable("author") String authorName){
        return bookService.listBooksByAuthor(authorName);
    }

    @GetMapping("/{isbn}")
    public Book findByIsbn(@PathVariable("isbn") String isbn){
        return bookService.findByIsbn(isbn);
    }
    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable("isbn") String isbn){
        bookService.deleteBook(isbn);
    }

    @GetMapping("/ind/{letter}")
    public List<Book> listBooksByLetter(@PathVariable("letter") String letter){
        return bookService.listBooksByLetter(letter);
    }
}
