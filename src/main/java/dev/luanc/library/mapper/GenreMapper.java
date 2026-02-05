package dev.luanc.library.mapper;

import dev.luanc.library.dto.genre.GenreResponse;
import dev.luanc.library.model.Genre;

import java.util.List;

public class GenreMapper {

    public static GenreResponse toResponse(Genre genre) {
        return new GenreResponse(genre.getId(), genre.getName());
    }

    public static List<GenreResponse> toResponseList(List<Genre> genres) {
        return genres.stream()
                .map(GenreMapper::toResponse)
                .toList();
    }
}
