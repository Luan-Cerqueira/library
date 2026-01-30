package dev.luanc.library.dto.bookcopy;

import dev.luanc.library.model.Book;

import java.util.List;

public record AddBookCopyResponse(
        Book book,
        List<String> assetTag
) {
}
