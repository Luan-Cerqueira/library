package dev.luanc.library.dto.bookcopy;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record AddBookCopyRequest(

        @NotBlank(message = "bookName: Is required")
        String bookName,

        @NotEmpty(message = "quantity: Is required")
        short quantity
) {
}
