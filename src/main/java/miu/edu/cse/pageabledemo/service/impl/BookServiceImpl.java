package miu.edu.cse.pageabledemo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.edu.cse.pageabledemo.dto.BookDto;
import miu.edu.cse.pageabledemo.model.Book;
import miu.edu.cse.pageabledemo.repository.BookRepository;
import miu.edu.cse.pageabledemo.service.BookService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    @Override
    public Optional<BookDto> addBook(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        Book savedBook = bookRepository.save(book);
        return Optional.of(modelMapper.map(savedBook, BookDto.class));
    }

    @Override
    public Optional<List<BookDto>> addAllBooks(List<BookDto> bookDtos) {
        List<Book> books = modelMapper.map(bookDtos, new TypeToken<List<Book>>() {}.getType());
        List<Book> savedBookds = bookRepository.saveAll(books);
        bookDtos = modelMapper.map(savedBookds, new TypeToken<List<BookDto>>() {}.getType());
        return Optional.of(bookDtos);
    }

    @Override
    public Page<BookDto> findAll(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<Book> bookPages = bookRepository.findAll(pageable);
        List<BookDto> bookDtos = bookPages.stream()
                .map(book -> modelMapper.map(book, BookDto.class))
                .collect(Collectors.toList());
        return new PageImpl<>(bookDtos, pageable, bookPages.getTotalElements());
    }
}
