package dev.luanc.library.service;

import dev.luanc.library.dto.bookcopy.AddBookCopyRequest;
import dev.luanc.library.dto.bookcopy.AddBookCopyResponse;
import dev.luanc.library.dto.bookcopy.BookCopiesDTO;
import dev.luanc.library.exception.ResourceNotFoundException;
import dev.luanc.library.mapper.BookCopyMapper;
import dev.luanc.library.model.Book;
import dev.luanc.library.model.BookCopy;
import dev.luanc.library.repository.BookCopyRepository;
import dev.luanc.library.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookCopyService {
    private BookCopyRepository bookCopyRepository;
    private BookRepository bookRepository;

    @Transactional
    public AddBookCopyResponse addBookCopy(AddBookCopyRequest bookCopyReq) {
        Book book = bookRepository.findBookByTitle(bookCopyReq.bookName())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        int currentYear = LocalDate.now().getYear();
        Integer lastSequence = bookCopyRepository.findLastSequenceByYear(currentYear);
        int nextNumber = (lastSequence == null) ? 1 : lastSequence + 1;

        Short lastCopy = bookCopyRepository.findLastCopyNumberByTitle(book.getTitle());
        short nextCopy = (lastCopy == null) ? 1 : (short) (lastCopy + 1);

        List<BookCopy> newCopies = new ArrayList<>();
        List<String> assetTags = new ArrayList<>();

        for (int i = 0; i < bookCopyReq.quantity(); i++) {
            String assetTag = String.format("LIB-%d-%05d", currentYear, nextNumber);

            BookCopy bc = new BookCopy();
            bc.setBook(book);
            bc.setAssetTag(assetTag);
            bc.setCopyNumber(nextCopy);
            newCopies.add(bc);

            assetTags.add(assetTag);

            nextCopy++;
            nextNumber++;
        }
        AddBookCopyResponse bookRes = new AddBookCopyResponse(book.getTitle(), assetTags);
        bookCopyRepository.saveAll(newCopies);
        return bookRes;
    }

    public List<BookCopiesDTO> getBookCopiesByBookTitle(Integer id) {
        return BookCopyMapper.toBookCopiesList
                (bookCopyRepository
                        .getBookCopyByBookId(id));
    }

    public BookCopiesDTO getBookCopyById(Integer id) {
        return BookCopyMapper.toBookCopiesDTO
                (bookCopyRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Book Copy Not Found")));
    }
}
