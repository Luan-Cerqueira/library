package dev.luanc.library.controller;

import dev.luanc.library.dto.genre.GenreDTO;
import dev.luanc.library.dto.genre.GenreResponse;
import dev.luanc.library.dto.publisher.PublisherDTO;
import dev.luanc.library.model.Genre;
import dev.luanc.library.model.Publisher;
import dev.luanc.library.service.GenreService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
@AllArgsConstructor
public class GenreController {
    private GenreService genreService;

    @PostMapping
    public ResponseEntity<GenreDTO> addGenre(@RequestBody GenreDTO genreDTO) {
        Genre genre = genreService.addGenre(genreDTO);
        GenreDTO genreRes = new GenreDTO(genre.getName());
        return new ResponseEntity<>(genreRes, HttpStatus.CREATED);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<GenreResponse> getGenre(@PathVariable Integer id) {
        GenreResponse genre = genreService.getGenreById(id);
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GenreResponse>> getAllGenres() {
        return new ResponseEntity<>(genreService.getAllGenres(), HttpStatus.OK);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<GenreDTO> updateGenre(@PathVariable Integer id, @RequestBody GenreDTO genreDTO) {
        Genre genre = genreService.updateGenre(id, genreDTO);
        GenreDTO genreRes = new GenreDTO(genre.getName());
        return new ResponseEntity<>(genreRes, HttpStatus.OK);
    }
}
