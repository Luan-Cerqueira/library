package dev.luanc.library.controller;

import dev.luanc.library.dto.bookcopy.AddBookCopyRequest;
import dev.luanc.library.dto.bookcopy.AddBookCopyResponse;
import dev.luanc.library.dto.bookcopy.BookCopiesDTO;
import dev.luanc.library.model.BookCopy;
import dev.luanc.library.service.BookCopyService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/copies")
@AllArgsConstructor
@Tag(name = "BookCopy", description = "BookCopy Controller for book copies management")
public class BookCopyController {
    private BookCopyService bookCopyService;

    @PostMapping
    public ResponseEntity<AddBookCopyResponse> addBookCopy(@Valid @RequestBody AddBookCopyRequest bookCopyReq){
        return new ResponseEntity<>(bookCopyService.addBookCopy(bookCopyReq), HttpStatus.CREATED);
    }

    @GetMapping({"/book/{id}"})
    public ResponseEntity<List<BookCopiesDTO>> getBookCopiesByTitle(@PathVariable Integer id){
        return new ResponseEntity<>(bookCopyService.getBookCopiesByBookTitle(id), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<BookCopiesDTO> getBookCopiesById(@PathVariable Integer id){
        return new ResponseEntity<>(bookCopyService.getBookCopyById(id), HttpStatus.OK);
    }
}
