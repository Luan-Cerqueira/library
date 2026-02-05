package dev.luanc.library.mapper;

import dev.luanc.library.dto.book.AddBookToEntity;
import dev.luanc.library.dto.book.BookResponse;
import dev.luanc.library.model.Book;

import java.util.List;

public class BookMapper {

    public static Book toEntity(AddBookToEntity bookReq){
        return Book.builder()
                .title(bookReq.title())
                .isbn(bookReq.isbn())
                .language(bookReq.language())
                .publicationDate(bookReq.publicationDate())
                .printLength(bookReq.printLength())
                .publisher(bookReq.publisher())
                .authors(bookReq.authors())
                .genres(bookReq.genres())
                .build();
    }

    public static BookResponse toResponse(Book book){
        return new BookResponse(
                book.getTitle(),
                book.getIsbn(),
                book.getLanguage(),
                book.getPublicationDate(),
                book.getPrintLength()
        );
    }

    public static List<BookResponse> toResponseList(List<Book> books) {
        return books.stream()
                .map(BookMapper::toResponse)
                .toList();
    }
}
