package dev.luanc.library.dto.bookcopy;

public record AddBookCopyRequest(
        String bookName,
        short quantity
) {
}
