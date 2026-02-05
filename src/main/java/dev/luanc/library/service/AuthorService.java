package dev.luanc.library.service;

import dev.luanc.library.dto.author.AuthorDTO;
import dev.luanc.library.mapper.AuthorMapper;
import dev.luanc.library.model.Author;
import dev.luanc.library.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorDTO addAuthor(AuthorDTO authorReq) {
        Author newAuthor = authorRepository.save(AuthorMapper.toEntity(authorReq));
        return AuthorMapper.toAuthorDTO(newAuthor);
    }

    public AuthorDTO updateAuthor(int id, AuthorDTO authorReq) {
        Author updatedAuthor = authorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        updatedAuthor.setName(authorReq.name() != null ? authorReq.name() : updatedAuthor.getName());
        updatedAuthor.setNacionality(authorReq.nacionality() != null ? authorReq.nacionality() : updatedAuthor.getNacionality());

        return AuthorMapper.toAuthorDTO(authorRepository.save(updatedAuthor));
    }

    public List<AuthorDTO> getAllAuthors() {
        return AuthorMapper.toAuthorDTOList(authorRepository.findAll());
    }

    public AuthorDTO getAuthorById(int id) {
        return AuthorMapper.toAuthorDTO(authorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found")));
    }
}
