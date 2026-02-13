package dev.luanc.library.dto.publisher;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record PublisherDTO(
        @NotBlank(message = "name: Is required")
        @Length(min = 1, max = 120, message = "name: Must be of 1 - 120 characters")
        String name,

        @NotBlank(message = "country: Is required")
        @Length(min = 1, max = 60, message = "country: Must be of 1 - 60 characters")
        String country
) {
}
