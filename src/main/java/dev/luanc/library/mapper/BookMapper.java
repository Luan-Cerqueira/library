package dev.luanc.library.mapper;

import dev.luanc.library.dto.book.AddBookToEntity;
import dev.luanc.library.dto.book.AddBookResponse;
import dev.luanc.library.model.Book;

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

    public static AddBookResponse toResponse(Book book){
        return new AddBookResponse(
                book.getTitle(),
                book.getIsbn(),
                book.getLanguage(),
                book.getPublicationDate(),
                book.getPrintLength()
        );
    }
}
