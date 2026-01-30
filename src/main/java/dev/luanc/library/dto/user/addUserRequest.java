package dev.luanc.library.dto.user;

public record addUserRequest(
        String name,
        String email,
        String password,
        String CPF
) {
}
