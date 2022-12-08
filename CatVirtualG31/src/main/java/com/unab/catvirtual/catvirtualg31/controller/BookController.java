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

    @PutMapping("/save")
    public Book saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{isbn}")
    public void deleteBook(@PathVariable("isbn") String isbn){
        bookService.deleteBook(isbn);
    }

    @GetMapping("/all")
    public List<Book> listBooks(){
        return bookService.listBooks();
    }

    @GetMapping("/{isbn}")
    public Book findByIsbn(@PathVariable("isbn") String isbn){
        return bookService.findByIsbn(isbn);
    }

    @GetMapping("/category/{catName}")
    public List<Book> listBooksByCategory(@PathVariable("catName") String categoryName){
        return bookService.listBooksByCategory(categoryName);
    }

    @GetMapping("/author/{author}")
    public List<Book> listBooksByAuthor(@PathVariable("author") String authorName){
        return bookService.listBooksByAuthor(authorName);
    }



    @GetMapping("/ind/{letter}")
    public List<Book> listBooksByLetter(@PathVariable("letter") String letter){
        return bookService.listBooksByLetter(letter);
    }

    @GetMapping("/price/{inf}/{sup}")
    public List<Book> listBooksByRange(@PathVariable("inf") long precioInferior, @PathVariable("sup") long precioSuperior){
        return bookService.listBooksByRange(precioInferior,precioSuperior);
    }
}
