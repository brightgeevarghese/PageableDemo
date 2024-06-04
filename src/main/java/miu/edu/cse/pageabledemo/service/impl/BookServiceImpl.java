package miu.edu.cse.pageabledemo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.pageabledemo.model.Book;
import miu.edu.cse.pageabledemo.repository.BookRepository;
import miu.edu.cse.pageabledemo.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public Optional<Book> addBook(Book book) {
        return Optional.of(bookRepository.save(book));
    }

    @Override
    public Optional<List<Book>> addAllBooks(List<Book> books) {
        return Optional.of(bookRepository.saveAll(books));
    }

    @Override
    public Page<Book> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return bookRepository.findAll(pageable);
    }
}
