package dev.luanc.library.dto.user;

import jakarta.validation.constraints.NotBlank;

public record LoginRequest(
    @NotBlank(message = "email: Is required") String email,
    @NotBlank(message = "password: Is required") String password
) {
}
