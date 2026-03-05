package dev.luanc.library.dto.bookcopy;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddBookCopyRequest(

        @NotBlank(message = "bookName: Is required")
        String bookName,

        @NotNull(message = "quantity: Is required")
        short quantity
) {
}
