package dev.luanc.library.mapper;

import dev.luanc.library.dto.author.AuthorDTO;
import dev.luanc.library.model.Author;

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
}
