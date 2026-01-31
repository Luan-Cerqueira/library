package dev.luanc.library.dto.book;

import dev.luanc.library.model.Author;
import dev.luanc.library.model.Genre;
import dev.luanc.library.model.Publisher;

import java.time.LocalDate;
import java.util.Set;

public record AddBookToEntity(
        String title,
        String isbn,
        String language,
        LocalDate publicationDate,
        short printLength,
        Publisher publisher,
        Set<Genre> genres,
        Set<Author> authors
) {
}
