package dev.luanc.library.dto.book;

import java.time.LocalDate;

public record BookResponse(
        String title,
        String isbn,
        String language,
        LocalDate publicationDate,
        short printLenght
) {
}
