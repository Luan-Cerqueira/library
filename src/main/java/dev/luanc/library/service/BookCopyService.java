package dev.luanc.library.service;

import dev.luanc.library.dto.bookcopy.AddBookCopyRequest;
import dev.luanc.library.dto.bookcopy.AddBookCopyResponse;
import dev.luanc.library.model.Book;
import dev.luanc.library.model.BookCopy;
import dev.luanc.library.repository.BookCopyRepository;
import dev.luanc.library.repository.BookRepository;
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

    public AddBookCopyResponse addBookCopy(AddBookCopyRequest bookCopyReq) {
        Book book = bookRepository.findBookByTitle(bookCopyReq.bookName())
                .orElseThrow(() -> new RuntimeException("Book not found"));

        int currentYear = LocalDate.now().getYear();
        Integer lastSequence = bookCopyRepository.findLastSequenceByYear(currentYear);
        int nextNumber = (lastSequence == null) ? 1 : lastSequence + 1;

        Integer lastCopy = bookCopyRepository.findLastCopyNumberByTitle(book.getTitle());
        int nextCopy = (lastCopy == null) ? 1 : lastCopy + 1;

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
        AddBookCopyResponse bookRes = new AddBookCopyResponse(book, assetTags);
        bookCopyRepository.saveAll(newCopies);
        return bookRes;
    }

    public List<BookCopy> getBookCopies(){
        return bookCopyRepository.findAll();
    }

    public BookCopy getBookCopyById(Long id){
        return bookCopyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book Copy Not Found"));
    }
}
