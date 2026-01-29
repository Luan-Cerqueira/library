package dev.luanc.library.service;

import dev.luanc.library.model.Author;
import dev.luanc.library.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;

    public Author addAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(int id, Author author) {
        Author updatedAuthor = authorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found"));
        updatedAuthor.setName(author.getName() != null ? author.getName() : updatedAuthor.getName());
        updatedAuthor.setNacionality(author.getNacionality() != null ? author.getNacionality() : updatedAuthor.getNacionality());
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
