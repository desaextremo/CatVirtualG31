package com.unab.catvirtual.catvirtualg31.controller;

import com.unab.catvirtual.catvirtualg31.entity.Book;
import com.unab.catvirtual.catvirtualg31.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/all")
    public List<Book> listBooks(){
        return bookService.listBooks();
    }

    @GetMapping("/{catName}")
    public List<Book> listBooksByCategory(@PathVariable("catName") String categoryName){
        return bookService.listBooksByCategory(categoryName);
    }
}
