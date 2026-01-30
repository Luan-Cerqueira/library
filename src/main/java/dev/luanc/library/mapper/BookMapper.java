package dev.luanc.library.mapper;

import dev.luanc.library.dto.book.AddBookRequest;
import dev.luanc.library.dto.book.AddBookResponse;
import dev.luanc.library.model.Book;

public class BookMapper {

    public static Book toEntity(AddBookRequest bookReq){
        return Book.builder()
                .title(bookReq.title())
                .isbn(bookReq.isbn())
                .language(bookReq.language())
                .publicationDate(bookReq.publicationDate())
                .printLenght(bookReq.printLenght())
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
                book.getPrintLenght()
        );
    }
}
