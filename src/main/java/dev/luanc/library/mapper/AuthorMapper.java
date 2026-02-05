package dev.luanc.library.mapper;

import dev.luanc.library.dto.author.AuthorDTO;
import dev.luanc.library.dto.publisher.PublisherDTO;
import dev.luanc.library.model.Author;
import dev.luanc.library.model.Publisher;

import java.util.List;

public class AuthorMapper {
    public static Author toEntity(AuthorDTO authorDTO) {
        return Author.builder()
                .name(authorDTO.name())
                .nacionality(authorDTO.nacionality())
                .build();
    }

    public static AuthorDTO toAuthorDTO(Author author) {
        return new AuthorDTO(
                author.getName(),
                author.getNacionality()
        );
    }

    public static List<AuthorDTO> toAuthorDTOList(List<Author> authors) {
        return authors.stream()
                .map(AuthorMapper::toAuthorDTO)
                .toList();
    }
}
