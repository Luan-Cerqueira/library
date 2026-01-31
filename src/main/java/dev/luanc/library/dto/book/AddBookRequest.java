package dev.luanc.library.dto.book;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;
import java.util.Set;

public record AddBookRequest(
        String title,
        String isbn,
        String language,
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate publicationDate,
        short printLength,
        String publisher,
        Set<String> genres,
        Set<String> authors
) {
}
