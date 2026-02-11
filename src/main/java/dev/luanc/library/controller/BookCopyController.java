package dev.luanc.library.controller;

import dev.luanc.library.dto.bookcopy.AddBookCopyRequest;
import dev.luanc.library.dto.bookcopy.AddBookCopyResponse;
import dev.luanc.library.dto.bookcopy.BookCopiesDTO;
import dev.luanc.library.model.BookCopy;
import dev.luanc.library.service.BookCopyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/copies")
@AllArgsConstructor
public class BookCopyController {
    private BookCopyService bookCopyService;

    @PostMapping
    public ResponseEntity<AddBookCopyResponse> addBookCopy(@RequestBody AddBookCopyRequest bookCopyReq){
        return new ResponseEntity<>(bookCopyService.addBookCopy(bookCopyReq), HttpStatus.CREATED);
    }

    @GetMapping({"/book/{id}"})
    public ResponseEntity<List<BookCopiesDTO>> getBookCopiesByTitle(@PathVariable Long id){
        return new ResponseEntity<>(bookCopyService.getBookCopiesByBookTitle(id), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<BookCopiesDTO> getBookCopiesById(@PathVariable Long id){
        return new ResponseEntity<>(bookCopyService.getBookCopyById(id), HttpStatus.OK);
    }
}
