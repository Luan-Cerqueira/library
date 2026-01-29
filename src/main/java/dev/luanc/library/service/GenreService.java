package dev.luanc.library.service;

import dev.luanc.library.model.Genre;
import dev.luanc.library.repository.GenreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public Genre addGenre(Genre genre){
        return genreRepository.save(genre);
    }
    public Genre updateGenre(int id, Genre genre){
        Genre updatedGenre = genreRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        updatedGenre.setName(genre.getName() != null ? genre.getName() : updatedGenre.getName());
        return genreRepository.save(updatedGenre);
    }
    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }
    public Genre getGenreById(int id){
        return genreRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
    }

}
