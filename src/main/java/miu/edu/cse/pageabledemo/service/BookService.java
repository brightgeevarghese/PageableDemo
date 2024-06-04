package miu.edu.cse.pageabledemo.service;

import miu.edu.cse.pageabledemo.dto.BookDto;
import miu.edu.cse.pageabledemo.model.Book;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Optional<BookDto> addBook(BookDto book);
    Optional<List<BookDto>> addAllBooks(List<BookDto> books);
    Page<BookDto> findAll(int pageNo, int pageSize, String sortBy, String sortDirection);
}
