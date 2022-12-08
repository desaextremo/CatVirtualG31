package com.unab.catvirtual.catvirtualg31.repository;

import com.unab.catvirtual.catvirtualg31.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {
    public List<Book> findByCategory(String categoryName);

    public List<Book> findByAuthor(String authorName);

    public List<Book> findByTitleStartsWith(String letter);

    @Query(value="{ price: { $gte:?0, $lte: ?1 }}",sort="{ price:1 }")
    public List<Book> listBooksByRange(long precioInferior, long precioSuperior );
}
