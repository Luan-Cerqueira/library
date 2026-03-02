package dev.luanc.library.exception;

import java.time.LocalDateTime;

public record ErrorMessage(
        LocalDateTime timestamp,
        int status,
        String description,
        Object message
) {
}
