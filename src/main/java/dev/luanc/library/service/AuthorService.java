package dev.luanc.library.service;

import dev.luanc.library.dto.author.authorRequest;
import dev.luanc.library.model.Author;
import dev.luanc.library.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Author addAuthor(authorRequest authorReq) {
        Author newAuthor = new Author();
        newAuthor.setName(authorReq.name());
        newAuthor.setNacionality(authorReq.nacionality());
        return authorRepository.save(newAuthor);
    }

    public Author updateAuthor(int id, authorRequest authorReq) {
        Author updatedAuthor = authorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        updatedAuthor.setName(authorReq.name() != null ? authorReq.name() : updatedAuthor.getName());
        updatedAuthor.setNacionality(authorReq.nacionality() != null ? authorReq.nacionality() : updatedAuthor.getNacionality());
        return authorRepository.save(updatedAuthor);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(int id) {
        return authorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
    }
}
