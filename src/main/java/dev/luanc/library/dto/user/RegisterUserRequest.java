package dev.luanc.library.dto.user;

public record RegisterUserRequest(
        String name,
        String email,
        String password,
        String CPF
) {
}
