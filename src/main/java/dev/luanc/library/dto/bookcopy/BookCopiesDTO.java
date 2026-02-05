package dev.luanc.library.dto.bookcopy;

import dev.luanc.library.model.enums.BookCopyStatus;

public record BookCopiesDTO(
        String title,
        String assetTag,
        int copyNumber,
        BookCopyStatus status
) {
}
