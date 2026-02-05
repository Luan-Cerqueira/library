package dev.luanc.library.service;

import dev.luanc.library.dto.book.AddBookToEntity;
import dev.luanc.library.dto.book.AddBookRequest;
import dev.luanc.library.dto.book.BookResponse;
import dev.luanc.library.mapper.BookMapper;
import dev.luanc.library.model.Author;
import dev.luanc.library.model.Book;
import dev.luanc.library.model.Genre;
import dev.luanc.library.model.Publisher;
import dev.luanc.library.repository.AuthorRepository;
import dev.luanc.library.repository.BookRepository;
import dev.luanc.library.repository.GenreRepository;
import dev.luanc.library.repository.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;


    public BookResponse addBook(AddBookRequest bookReq) {
        Publisher publisher = publisherRepository
                .findByName(bookReq.publisher())
                .orElseThrow(() -> new RuntimeException("Publisher not found"));
        Set<Genre> genres = new HashSet<>();
        for (String g : bookReq.genres()) {
            genres.add(genreRepository.findGenreByName(g)
                    .orElseThrow(() -> new RuntimeException("Genre not found")));
        }
        Set<Author> authors = new HashSet<>();
        for (String a : bookReq.authors()) {
            authors.add(authorRepository.findAuthorByName(a)
                    .orElseThrow(() -> new RuntimeException("Author not found")));
        }
        AddBookToEntity book = new AddBookToEntity(
                bookReq.title(),
                bookReq.isbn(),
                bookReq.language(),
                bookReq.publicationDate(),
                bookReq.printLength(),
                publisher,
                genres,
                authors
        );
        Book bookR = bookRepository.save(BookMapper.toEntity(book));
        return BookMapper.toResponse(bookR);
    }

    public List<BookResponse> getAllBooks() {
        return BookMapper.toResponseList(bookRepository.findAll());
    }

    public BookResponse getBookById(Long id) {
        return BookMapper
                .toResponse(bookRepository
                        .findById(id)
                        .orElseThrow(() -> new RuntimeException("Book not found")));
    }
}
