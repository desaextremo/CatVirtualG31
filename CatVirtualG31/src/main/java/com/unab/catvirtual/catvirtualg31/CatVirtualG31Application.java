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
        //borrado de datos de una colleccion
        //bookRepository.deleteAll();

        //Definir 6 Libros que reciban diferentes argumentos o valores en el constructor
        /*
        Book libroUno = new Book(); //sin valores
        Book libroDos = new Book("135","VIVIR PARA CONTARLA"); //con isbn y titulo
        Book libroTres = new Book("136","LA CASA VERDE","MARIO VARGAS LLOSA"); //con isbn, titulo, autor
        Book libroCuatro = new Book("137","LA CIUDAD Y LOS PERROS","MARIO VARGAS LLOSA",50000);//con isbn, titulo,autor, precio
        Book libroCinco = new Book("138","LA GUERRA DEL FIN DEL MUNDO",50000,500); //con isbn, titulo, precio, paginas
        Book libroSeis = new Book("139","LOS CACHORROS",500);; //isbn, titulo, paginas
        */
        //insertar un libro
        /*
        bookRepository.insert(libroUno);
        bookRepository.insert(libroDos);
        bookRepository.insert(libroTres);
        bookRepository.insert(libroCuatro);
        bookRepository.save(libroCinco);
        bookRepository.insert(libroSeis);
        */
        /*
        //Definir 6 Libros que reciban diferentes argumentos o valores en el constructor
        Book libroUno = Book.builder().build(); //sin valores
        Book libroDos = Book.builder().isbn("135").title("VIVIR PARA CONTARLA").build(); //con isbn y titulo
        Book libroTres = Book.builder().isbn("136").title("LA CASA VERDE").author("MARIO VARGAS LLOSA").build();//con isbn, titulo, autor
        Book libroCuatro = Book.builder().isbn("137").title("LA CIUDAD Y LOS PERROS").author("MARIO VARGAS LLOSA").price(50000).build();//con isbn, titulo,autor, precio
        Book libroCinco = Book.builder().isbn("138").title("LA GUERRA DEL FIN DEL MUNDO").price(450000).pages(350).build(); //con isbn, titulo, precio, paginas
        Book libroSeis = Book.builder().isbn("139").title("LOS CACHORROS").pages(500).build(); //isbn, titulo, paginas

        //insertar varios
        bookRepository.saveAll(
                List.of(libroUno,
                        libroDos,
                        libroTres,
                        libroCuatro,
                        libroCinco,
                        libroSeis)
        );
        */
        /*
        //insertar varios
        bookRepository.saveAll(
                List.of(Book.builder().build(),
                        Book.builder().isbn("135").title("VIVIR PARA CONTARLA").build(),
                        Book.builder().isbn("136").title("LA CASA VERDE").author("MARIO VARGAS LLOSA").build(),
                        Book.builder().isbn("137").title("LA CIUDAD Y LOS PERROS").author("MARIO VARGAS LLOSA").price(50000).build(),
                        Book.builder().isbn("138").title("LA GUERRA DEL FIN DEL MUNDO").price(450000).pages(350).build(),
                        Book.builder().isbn("139").title("LOS CACHORROS").pages(500).build())
        );
        */

        //Listar o buscar
        List<Book> catalogo =  bookRepository.findAll();
        System.out.println("Listado de Libros");
        for (Book book:catalogo) {
            System.out.println(book);
        }

        //actualizar
        //actualizar
        //borrar

        //Listar o buscar libros de una categoria
        catalogo =  bookRepository.findByCategory("CUENTOS");
        System.out.println("Listado de Libros para la categoria CUENTOS");
        for (Book book:catalogo) {
            System.out.println(book);
        }
    }
}
