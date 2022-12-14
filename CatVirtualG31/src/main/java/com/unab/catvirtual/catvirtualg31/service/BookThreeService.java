package com.unab.catvirtual.catvirtualg31.service;

import com.unab.catvirtual.catvirtualg31.entity.BookThree;
import com.unab.catvirtual.catvirtualg31.repository.BookThreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookThreeService {
    @Autowired
    private BookThreeRepository bookThreeRepository;

    public List<BookThree> listBook(){
        return bookThreeRepository.findAll();
    }

    public BookThree queryBook(String isbn){
        BookThree BookThree;
        Optional<BookThree> optional =  bookThreeRepository.findById(isbn);

        if(!optional.isEmpty()){
            BookThree = optional.get();
        }else{
            BookThree = null;
        }
        return BookThree;
    }

    public BookThree addBook(BookThree BookThree){
        BookThree BookThreeTwo;
        Optional<BookThree> optional =  bookThreeRepository.findById(BookThree.getIsbn());

        if(optional.isEmpty()) return bookThreeRepository.insert(BookThree);
        else return null;
    }

    public BookThree saveBook(BookThree bookThree){
        //1 Buscamos si el libro existe y recuperamos toda su información
        Optional<BookThree> opcional = bookThreeRepository.findById(bookThree.getIsbn());
        //el libro existe
        if (!opcional.isEmpty()){
            BookThree libroBD = opcional.get();
            //2 comparamos si los valores actuales son diferentes a los valores del libro recibido como parametro

            if (bookThree.getCategory()!=null) libroBD.setCategory(bookThree.getCategory());
            if (bookThree.getAuthor()!=null) libroBD.setAuthor(bookThree.getAuthor());
            if (bookThree.getDescription()!=null) libroBD.setDescription(bookThree.getDescription());
            if (bookThree.getTitle()!=null) libroBD.setTitle(bookThree.getTitle());
            if(bookThree.getPages()!=0) libroBD.setPages(bookThree.getPages());
            if(bookThree.getPrice()!=0) libroBD.setPrice(bookThree.getPrice());
            if(bookThree.getYear()!=0) libroBD.setYear(bookThree.getYear());
            if(bookThree.getDescription()!=null) libroBD.setDescription(bookThree.getDescription());

            return bookThreeRepository.save(libroBD);
        }else{ //el libro no existe
            return null;
        }
    }

    public void deleteBook(String id){
        bookThreeRepository.deleteById(id);
    }

    public List<BookThree> findBookRange(long priceMin, long priceMax){
        return bookThreeRepository.findBookRange(priceMin,priceMax);
    }

    public List<BookThree> findByLetter(String letter){
        return bookThreeRepository.findByLetter(letter);
    }
}
