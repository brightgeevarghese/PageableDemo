package miu.edu.cse.pageabledemo.repository;

import miu.edu.cse.pageabledemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
