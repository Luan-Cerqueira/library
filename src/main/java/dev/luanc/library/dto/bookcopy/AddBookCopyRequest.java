package dev.luanc.library.dto.bookcopy;

import dev.luanc.library.model.Book;

public record AddBookCopyRequest(
        Book book,
        short quantity
) {
}
