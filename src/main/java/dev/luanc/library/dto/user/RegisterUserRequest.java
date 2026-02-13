package dev.luanc.library.dto.user;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public record RegisterUserRequest(
        @NotBlank(message = "name: Is required")
        @Length(min = 1, max = 255, message = "name: Must be of 1 - 255 characters")
        String name,

        @NotBlank(message = "email: Is required")
        @Length(min = 1, max = 100, message = "email: Must be of 1 - 100 characters")
        String email,

        @NotBlank(message = "password: Is required")
        @Length(min = 1, max = 100, message = "password: Must be of 1 - 100 characters")
        String password,

        @NotBlank(message = "CPF: Is required")
        @Length(min = 11, max = 11, message = "CPF: Must have 11 characters")
        String CPF
) {
}
