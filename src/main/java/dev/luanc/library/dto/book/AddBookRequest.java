package dev.luanc.library.dto.book;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Set;

public record AddBookRequest(
        @NotBlank(message = "title: Is required")
        @Length(min = 1, max = 100, message = "title: Must be of 1 - 100 characters")
        String title,

        @NotBlank(message = "isbn: Is required")
        @Length(min = 13, max = 13, message = "isbn: Must have 13 characters")
        String isbn,

        @NotBlank(message = "language: Is required")
        @Length(min = 1, max = 20, message = "language: Must be of 1 - 20 characters")
        String language,

        @NotEmpty(message = "publicationDate: Is required")
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate publicationDate,

        @NotEmpty(message = "printLength: Is required")
        short printLength,

        @NotBlank(message = "publisher: Is required")
        String publisher,

        @NotEmpty(message = "genres: Is required")
        Set<String> genres,

        @NotEmpty(message = "authors: Is required")
        Set<String> authors
) {
}
