package dev.luanc.library.service;

import dev.luanc.library.dto.genre.GenreDTO;
import dev.luanc.library.dto.genre.GenreResponse;
import dev.luanc.library.exception.ResourceNotFoundException;
import dev.luanc.library.mapper.GenreMapper;
import dev.luanc.library.model.Genre;
import dev.luanc.library.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public Genre addGenre(GenreDTO genre) {
        Genre newGenre = new Genre();
        newGenre.setName(genre.name());
        return genreRepository.save(newGenre);
    }

    public Genre updateGenre(int id, GenreDTO genre) {
        Genre updatedGenre = genreRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found"));
        updatedGenre.setName(genre.name() != null ? genre.name() : updatedGenre.getName());
        return genreRepository.save(updatedGenre);
    }

    public List<GenreResponse> getAllGenres() {
        return GenreMapper.toResponseList(genreRepository.findAll());
    }

    public GenreResponse getGenreById(int id) {
        return GenreMapper
                .toResponse(genreRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Genre not found")));
    }

}
