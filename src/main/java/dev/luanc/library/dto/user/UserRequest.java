package dev.luanc.library.dto.user;

public record UserRequest(
        String name,
        String email,
        String password,
        String CPF
) {
}
