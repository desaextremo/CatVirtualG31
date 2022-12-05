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
        /*
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
        oneBook.setSeleccionado(false);
        oneBook.setDescription("HISTORIA DEL GRAL AURELIANO BUENDIA");
        //Insertar el libro (documento) en la base de dato (en la coleccion books)
        bookRepository.insert(oneBook);

        //Crear Libros
        oneBook = new Book();
        //Asignar valores a los atributos del libro
        //Asignar atributos
        oneBook.setIsbn("124");
        oneBook.setCategory("LATINOAMERICANA");
        oneBook.setTitle("DEL AMOR Y OTROS DEMONIOS");
        oneBook.setAuthor("GABRIEL GARCIA MARQUEZ");

        //Insertar el libro (documento) en la base de dato (en la coleccion books)
        bookRepository.insert(oneBook);
        //Consultar datos del libro
        List<Book> catalogo =  bookRepository.findAll();
        System.out.println("Catalogo de Libros actualizado");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }

        //actualizar libro 124
        Optional<Book> opcional = bookRepository.findById("124");
        */

        /*
        oneBook = bookRepository.findById("125").get();
        System.out.printf("Datos del libro con isbn " + oneBook.getIsbn());
        System.out.println(oneBook);
        */

        /*
        if(!opcional.isEmpty()){
            oneBook = opcional.get();
            System.out.printf("Datos del libro con isbn " + oneBook.getIsbn());
            System.out.println(oneBook);

            //Actualizar valores pendientes: año, precio, paginas, seleccionado, descripccion

            //asigno valores al objeto
            oneBook.setYear(1994);
            oneBook.setPrice(55000);
            oneBook.setPages(250);
            oneBook.setSeleccionado(false);
            oneBook.setDescription("NOVELA QUE SE ORIGINA CON EL DESCUBRIMIENTO DE LA TUMBA DE SIERVA MARÍA DE TODOS LOS ÁNGELES. EL 26 DE OCTUBRE DE 1949 EL REPORTERO GABRIEL GARCÍA MÁRQUEZ FUE ENVIADO AL ANTIGUO CONVENTO DE SANTA CLARA, QUE IBA A SER DEMOLIDO PARA EDIFICAR SOBRE ÉL UN HOTEL DE CINCO ESTRELLAS, A PRESENCIAR EL VACIADO DE LAS CRIPTAS FUNERARIAS Y A CUBRIR LA NOTICIA. SE EXHUMARON LOS RESTOS DE UN VIRREY DEL PERÚ Y SU AMANTE SECRETA, UN OBISPO, VARIAS ABADESAS, UN BACHILLER DE ARTES Y UNA MARQUESA. PERO LA SORPRESA SALTÓ AL DESTAPAR LA TERCERA HORNACINA DEL ALTAR MAYOR: SE DESPARRAMÓ UNA CABELLERA DE COLOR COBRE, DE VEINTIDÓS METROS Y ONCE CENTÍMETROS DE LARGO, PERTENECIENTE A UNA NIÑA. EN LA LÁPIDA APENAS SE LEÍA EL NOMBRE: SIERVA MARÍA DE TODOS LOS ÁNGELES. «MI ABUELA ME CONTABA DE NIÑO LA LEYENDA DE UNA MARQUESITA DE DOCE AÑOS CUYA CABELLERA LE ARRASTRABA COMO UNA COLA DE NOVIA, QUE HABÍA MUERTO DEL MAL DE RABIA POR EL MORDISCO DE UN PERRO, Y ERA VENERADA EN LOS PUEBLOS DEL CARIBE POR SUS MUCHOS MILAGROS.»");

            //lo actualizo en la base de datos
            bookRepository.save(oneBook);

            //Consultar datos del libro
            catalogo =  bookRepository.findAll();
            System.out.println("Catalogo de Libros actualizado");
            for (Book book:catalogo) {
                System.out.println(book.toString());
            }

            //borrar el libro de la base da datos
            bookRepository.delete(oneBook);

            //Consultar datos del libro
            catalogo =  bookRepository.findAll();
            System.out.println("Catalogo de Libros actualizado");
            for (Book book:catalogo) {
                System.out.println(book.toString());
            }
        }else{
            System.out.println("El libro con isbn 125 no existe");
        }



        //insert masivo
        Book oneBook = Book.builder().build();
        //Asignar valores a los atributos del libro
        //Asignar atributos
        oneBook.setIsbn("123");
        oneBook.setCategory("LATINOAMERICANA");
        oneBook.setTitle("EL CORONEL NO TIENE QUIEN LE ESCRIBA");
        oneBook.setAuthor("GABRIEL GARCIA MARQUEZ");
        oneBook.setPages(300);
        oneBook.setPrice(50000);
        oneBook.setSeleccionado(false);
        oneBook.setDescription("HISTORIA DEL GRAL AURELIANO BUENDIA");


        bookRepository.saveAll(

                List.of(oneBook,
                        Book.builder().category("NOVELAS").build(),
                        Book.builder().category("NOVELAS")
                                .title("DEL AMOR Y OTROS DEMONIOS")
                                .author("GABRIEL GARCIA MARQUEZ")
                                .pages(250)
                                .price(55000)
                                .year(1994)
                                .seleccionado(false)
                                .description("NOVELA QUE SE ORIGINA CON EL DESCUBRIMIENTO DE LA TUMBA DE SIERVA MARÍA DE TODOS LOS ÁNGELES. EL 26 DE OCTUBRE DE 1949 EL REPORTERO GABRIEL GARCÍA MÁRQUEZ FUE ENVIADO AL ANTIGUO CONVENTO DE SANTA CLARA, QUE IBA A SER DEMOLIDO PARA EDIFICAR SOBRE ÉL UN HOTEL DE CINCO ESTRELLAS, A PRESENCIAR EL VACIADO DE LAS CRIPTAS FUNERARIAS Y A CUBRIR LA NOTICIA. SE EXHUMARON LOS RESTOS DE UN VIRREY DEL PERÚ Y SU AMANTE SECRETA, UN OBISPO, VARIAS ABADESAS, UN BACHILLER DE ARTES Y UNA MARQUESA. PERO LA SORPRESA SALTÓ AL DESTAPAR LA TERCERA HORNACINA DEL ALTAR MAYOR: SE DESPARRAMÓ UNA CABELLERA DE COLOR COBRE, DE VEINTIDÓS METROS Y ONCE CENTÍMETROS DE LARGO, PERTENECIENTE A UNA NIÑA. EN LA LÁPIDA APENAS SE LEÍA EL NOMBRE: SIERVA MARÍA DE TODOS LOS ÁNGELES. «MI ABUELA ME CONTABA DE NIÑO LA LEYENDA DE UNA MARQUESITA DE DOCE AÑOS CUYA CABELLERA LE ARRASTRABA COMO UNA COLA DE NOVIA, QUE HABÍA MUERTO DEL MAL DE RABIA POR EL MORDISCO DE UN PERRO, Y ERA VENERADA EN LOS PUEBLOS DEL CARIBE POR SUS MUCHOS MILAGROS.»")
                                .build(),
                        Book.builder().category("NOVELAS")
                                .title("EL AMOR EN LOS TIEMPOS DEL CÓLERA")
                                .author("GABRIEL GARCIA MARQUEZ")
                                .pages(250)
                                .price(44000)
                                .year(1985)
                                .seleccionado(false)
                                .description("ES UNA NOVELA DEDICADA AL VERDADERO AMOR INSPIRADA EN LA RELACIÓN DE SUS PADRES. ESTA NOVELA DE GABRIEL GARCIA MARQUEZ ES UNO DE LOS LIBROS MÁS POPULARES DE LA LITERATURA DEL SIGLO XX EN ESPAÑOL. EL AUTOR G. MÁRQUEZ, EN 1985, PUBLICA EL LIBRO EL AMOR EN TIEMPOS DEL CÓLERA, UNA MEMORABLE NOVELA DE AMOR. FLORENTINO ARIZA Y FERMINA DAZA SE CONOCEN EN LA ADOLESCENCIA Y DURANTE MEDIO SIGLO RECORRERÁN UNA SERIE DE DESENCUENTROS, ATRAVESADOS POR LA VEGETACIÓN, LOS AROMAS, LOS SABORES Y LA HISTORIA DE UN PUEBLO COSTERO DEL CARIBE.")
                                .build(),
                        Book.builder().category("NOVELAS")
                                .title("EL CORONEL NO TIENE QUIEN LE ESCRIBA")
                                .author("GABRIEL GARCIA MARQUEZ")
                                .build(),
                        Book.builder()
                                .title("EL CORONEL NO TIENE QUIEN LE ESCRIBA")
                                .author("GABRIEL GARCIA MARQUEZ")
                                .build()
                        )
        );
        */
        //Consultar datos del libro
        List<Book> catalogo =  bookRepository.findByCategory("REPORTAJE");
        System.out.println("Catalogo de Libros de categoria: REPORTAJE");
        for (Book book:catalogo) {
            System.out.println(book.toString());
        }

    }
}
