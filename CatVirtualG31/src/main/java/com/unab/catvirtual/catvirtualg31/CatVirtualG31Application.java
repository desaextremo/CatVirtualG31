package com.unab.catvirtual.catvirtualg31;

import com.unab.catvirtual.catvirtualg31.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.unab.catvirtual.catvirtualg31.entity.Book;

import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class CatVirtualG31Application implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepository;

    public static void main(String[] args) {
        SpringApplication.run(CatVirtualG31Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Limpiar base de datos
        bookRepository.deleteAll();

        //Crear Libros
        Book oneBook = new Book();

        //Asignar valores a los atributos del libro
        //Asignar atributos
        oneBook.setIsbn("123");
        oneBook.setCategory("LATINOAMERICANA");
        oneBook.setTitle("EL CORONEL NO TIENE QUIEN LE ESCRIBA");
        oneBook.setAuthor("GABRIEL GARCIA MARQUEZ");
        oneBook.setPages(300);
        oneBook.setPrice(50000);
        oneBook.setDescription("HISTORIA DEL GRAL AURELIANO BUENDIA");

        //Insertar el libro (documento) en la base de dato (en la coleccion books)
        bookRepository.insert(oneBook);

        oneBook = new Book();
        oneBook.setIsbn("124");
        oneBook.setCategory("HISTORICA");
        oneBook.setTitle("EL GENERAL EN SU LABERINTO");
        oneBook.setAuthor("GABRIEL GARCIA MARQUEZ");
        oneBook.setPages(300);
        oneBook.setPrice(30000);
        oneBook.setDescription("HISTORIA DEL BOLIVAR EN SUS ULTIMOS DIAS");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        oneBook = new Book();
        oneBook.setIsbn("125");
        oneBook.setCategory("NARRATIVA");
        oneBook.setTitle("MEMORIAS DE MIS PUTAS TRISTES");
        oneBook.setAuthor("GABRIEL GARCIA MARQUEZ");
        oneBook.setPages(250);
        oneBook.setPrice(20000);
        oneBook.setDescription("HISTORIA DE UN VIEJO EN SUS ULTIMOS  DIAS DE VIDA");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        oneBook = new Book();
        oneBook.setIsbn("126");
        oneBook.setCategory("LATINOAMERICANA");
        oneBook.setTitle("PANTALEON EL VISITADOR");
        oneBook.setAuthor("MARIO VARGAS LLOSA");
        oneBook.setPages(300);
        oneBook.setPrice(50000);
        oneBook.setDescription("HISTORIA DEL BURDEL PERUANO");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        oneBook = new Book();
        oneBook.setIsbn("127");
        oneBook.setCategory("HISTORICA");
        oneBook.setTitle("EL SUEÑO DEL CELTA");
        oneBook.setAuthor("MARIO VARGAS LLOSA");
        oneBook.setPages(300);
        oneBook.setPrice(50000);
        oneBook.setDescription("HISTORIA DE UN DIPLOMATICO BRITANICO CON PROBLEMAS POR SU ORIENTACION SEXUAL");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        oneBook = new Book();
        oneBook.setIsbn("128");
        oneBook.setCategory("HISTORICA");
        oneBook.setTitle("EL SARI ROJO");
        oneBook.setAuthor("JAVIER MORO");
        oneBook.setPages(300);
        oneBook.setPrice(50000);
        oneBook.setDescription("SOBRE INDIRA GANDHI Y SU FAMILIA");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        oneBook = new Book();
        oneBook.setIsbn("129");
        oneBook.setCategory("HISTORICA");
        oneBook.setTitle("EL IMPERIO ESRES TU");
        oneBook.setAuthor("JAVIER MORO");
        oneBook.setPages(300);
        oneBook.setPrice(50000);
        oneBook.setDescription("HISTORIA DEL IMPERIO PORTUGUEZ EN BRASIL");

        //Insertar en la base de datos
        bookRepository.insert(oneBook);

        //Consultar datos del libro
        List<Book> catalogo =  bookRepository.findAll();

        System.out.println("Catalogo de Libros");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }

        //Recupero el documento
        Optional<Book> opcional = bookRepository.findById("127");

        if(!opcional.isEmpty()){
            oneBook =  opcional.get();
            oneBook.setPages(500);
            oneBook.setPrice(55000);
            oneBook.setDescription("LIBRO SUPER INTERESANTE");

            //actualizar el documento
            bookRepository.save(oneBook);

            //Consultar datos del libro
            catalogo =  bookRepository.findAll();
            System.out.println("Catalogo de Libros actualizado");
            for (Book book:catalogo) {
                System.out.println(book.toString());
            }

            //borrado de documento
            bookRepository.delete(oneBook);

            //Consultar datos del libro
            catalogo =  bookRepository.findAll();
            System.out.println("Catalogo de Libros actualizado - se elimino el #1|27");
            for (Book book:catalogo) {
                System.out.println(book.toString());
            }

        }else{
            System.out.println("No existe el documento asociado al isbn:127");
        }

        //buscar libros con la categoria LATINOAMERICANA
        catalogo = bookRepository.findByCategory("LATINOAMERICANA");
        System.out.println("Catalogo de Libros con categoria LATINOAMERICANA");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }

        //buscar libros con del autor JAVIER MORO
        catalogo = bookRepository.findByAuthor("JAVIER MORO");
        System.out.println("Catalogo de Libros del autor JAVIER MORO");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }

        //buscar libros que contengan la palabra "EL"
        catalogo = bookRepository.findByTitleContains("EL");
        System.out.println("Catalogo de Libros que contienen la palabra 'EL'");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }

        //buscar libros que inicien con la letra "E"
        catalogo = bookRepository.findByTitleStartsWith("E");
        System.out.println("Catalogo de Libros inicien con la letra 'E'");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }

        //buscar libros que tengan 300 paginas
        catalogo = bookRepository.findByPages(300);

        System.out.println("Catalogo de Libros que tengan 300 paginas");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }

        //buscar libros que tengan 300 paginas version alterna
        catalogo = bookRepository.findByPagesAlterno(300);

        System.out.println("Catalogo de Libros que tengan 300 paginas(V Alterna)");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }

        catalogo = bookRepository.findByPriceBetween(20000,30000);
        System.out.println("Catalogo de Libros que con precios entre 20000,30000");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }


    }
}
