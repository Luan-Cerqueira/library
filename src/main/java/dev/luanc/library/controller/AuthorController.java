package dev.luanc.library.controller;

import dev.luanc.library.dto.author.AuthorDTO;
import dev.luanc.library.model.Author;
import dev.luanc.library.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/authors")
@AllArgsConstructor
public class AuthorController {

    private AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorDTO> addAuthor(@RequestBody AuthorDTO authorReq) {
        AuthorDTO authorRes = authorService.addAuthor(authorReq);
        return new ResponseEntity<>(authorRes, HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<AuthorDTO> getAuthor(@PathVariable Integer id) {
        AuthorDTO author = authorService.getAuthorById(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AuthorDTO>> getAllAuthors() {
        return new ResponseEntity<>(authorService.getAllAuthors(), HttpStatus.OK);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable Integer id, @RequestBody AuthorDTO authorDTO) {
        return new ResponseEntity<>(authorService.updateAuthor(id, authorDTO), HttpStatus.OK);
    }
}


