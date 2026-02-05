package dev.luanc.library.mapper;

import dev.luanc.library.dto.bookcopy.BookCopiesDTO;
import dev.luanc.library.model.BookCopy;

import java.util.List;

public class BookCopyMapper {
    public static BookCopiesDTO toBookCopiesDTO(BookCopy bc) {
        return new BookCopiesDTO(
                bc.getBook().getTitle(),
                bc.getAssetTag(),
                bc.getCopyNumber(),
                bc.getStatus()
        );
    }

    public static List<BookCopiesDTO> toBookCopiesList(List<BookCopy> bcList) {
        return bcList.stream()
                .map(BookCopyMapper::toBookCopiesDTO)
                .toList();
    }
}
