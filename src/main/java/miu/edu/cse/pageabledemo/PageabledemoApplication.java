package miu.edu.cse.pageabledemo;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.pageabledemo.dto.BookDto;
import miu.edu.cse.pageabledemo.model.Book;
import miu.edu.cse.pageabledemo.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class PageabledemoApplication {

    private final BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(PageabledemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            BookDto b1 = new BookDto("Book A",
                    BigDecimal.valueOf(9.99),
                    LocalDate.of(2023, 8, 31));
            BookDto b2 = new BookDto("Book B",
                    BigDecimal.valueOf(19.99),
                    LocalDate.of(2023, 7, 31));
            BookDto b3 = new BookDto("Book C",
                    BigDecimal.valueOf(29.99),
                    LocalDate.of(2023, 6, 10));
            BookDto b4 = new BookDto("Book D",
                    BigDecimal.valueOf(39.99),
                    LocalDate.of(2023, 5, 5));
            BookDto b5 = new BookDto("Book E",
                    BigDecimal.valueOf(49.99),
                    LocalDate.of(2023, 4, 1));
            BookDto b6 = new BookDto("Book F",
                    BigDecimal.valueOf(59.99),
                    LocalDate.of(2023, 3, 1));
            bookService.addAllBooks(List.of(b1, b2, b3, b4, b5, b6));
            System.out.println("page#0, page size#3");
            bookService.findAll(0, 3, "id", "ASC")
                    .forEach(System.out::println);
            System.out.println("page#1, page size#3");
            bookService.findAll(1, 3, "id", "ASC")
                    .forEach(System.out::println);

            System.out.println("page#0, page size#2");
            bookService.findAll(0, 2, "id", "ASC")
                    .forEach(System.out::println);
            System.out.println("page#2, page size#2");
            bookService.findAll(2, 2, "id", "ASC")
                    .forEach(System.out::println);
            System.out.println("page#3, page size#1");
            bookService.findAll(3, 1, "id", "ASC")
                    .forEach(System.out::println);
            System.out.println("page#1, page size#3");
            bookService.findAll(1, 3, "publishDate", "desc")
                    .forEach(System.out::println);
        };
    }

}
