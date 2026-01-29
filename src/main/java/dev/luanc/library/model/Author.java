package dev.luanc.library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {

    @Id
    @Column(name = "author_id")
    private int id;
    private String name;
    private String nacionality;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.PERSIST)
    private Set<Book> books;
}
