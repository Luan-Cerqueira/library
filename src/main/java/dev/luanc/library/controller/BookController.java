package dev.luanc.library.controller;

import dev.luanc.library.dto.book.AddBookRequest;
import dev.luanc.library.dto.book.AddBookResponse;
import dev.luanc.library.model.Book;
import dev.luanc.library.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @PostMapping
    public ResponseEntity<AddBookResponse> addBook(@RequestBody AddBookRequest bookReq) {
        return new ResponseEntity<>(bookService.addBook(bookReq), HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }
}
