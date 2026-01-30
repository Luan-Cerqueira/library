package dev.luanc.library.service;

import dev.luanc.library.dto.book.AddBookRequest;
import dev.luanc.library.dto.book.AddBookResponse;
import dev.luanc.library.mapper.BookMapper;
import dev.luanc.library.model.Book;
import dev.luanc.library.model.Publisher;
import dev.luanc.library.repository.AuthorRepository;
import dev.luanc.library.repository.BookRepository;
import dev.luanc.library.repository.GenreRepository;
import dev.luanc.library.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

}
