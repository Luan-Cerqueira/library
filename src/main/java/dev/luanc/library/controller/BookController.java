package dev.luanc.library.controller;

import dev.luanc.library.dto.book.AddBookRequest;
import dev.luanc.library.dto.book.BookResponse;
import dev.luanc.library.model.Book;
import dev.luanc.library.service.BookService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
@Tag(name = "Book", description = "Book Controller for book management")
public class BookController {
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> addBook(@Valid @RequestBody AddBookRequest bookReq) {
        return new ResponseEntity<>(bookService.addBook(bookReq), HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<BookResponse> getBookById(@PathVariable Integer id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
}
