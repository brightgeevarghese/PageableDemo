package miu.edu.cse.pageabledemo.service;

import miu.edu.cse.pageabledemo.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<Book> addBook(Book book);
    Optional<List<Book>> addAllBooks(List<Book> books);
    Page<Book> findAll(int pageNo, int pageSize, String sortBy, String sortDirection);
}
