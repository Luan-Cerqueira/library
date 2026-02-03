package dev.luanc.library.dto.bookcopy;

public record ListBookCopies(
        String title,
        String assetTag,
        int copyNumber,
        String status
) {
}
