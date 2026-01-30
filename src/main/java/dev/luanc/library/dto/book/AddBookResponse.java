package dev.luanc.library.dto.book;

import java.time.LocalDate;

public record AddBookResponse(
        String title,
        String isbn,
        String language,
        LocalDate publicationDate,
        short printLenght
) {
}
