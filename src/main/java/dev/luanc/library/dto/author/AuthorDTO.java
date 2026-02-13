package dev.luanc.library.dto.author;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record AuthorDTO(
        @NotBlank(message = "name: Is required")
        @Length(min = 1, max = 255, message = "name: Must be of 1 - 255 characters")
        String name,

        @NotBlank(message = "nacionality: Is required")
        @Length(min = 1, max = 100, message = "name: Must be of 1 - 100 characters")
        String nacionality
) {
}
