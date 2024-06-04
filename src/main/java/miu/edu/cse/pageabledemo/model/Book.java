package miu.edu.cse.pageabledemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "books")
@NoArgsConstructor
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private BigDecimal price;
    private LocalDate publishDate;

    public Book(String title, BigDecimal price, LocalDate publishDate) {
        this.title = title;
        this.price = price;
        this.publishDate = publishDate;
    }
}
