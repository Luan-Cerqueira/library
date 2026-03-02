package dev.luanc.library.dto.genre;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record GenreDTO(
        @NotBlank(message = "name: Is required")
        @Length(min = 1, max = 20, message = "name: Must be of 1 - 20 characters")
        String name
) {
}
