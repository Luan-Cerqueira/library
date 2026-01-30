package dev.luanc.library.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Genre {
    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "genre_name", nullable = false, length = 20, unique = true)
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = CascadeType.PERSIST)
    private Set<Book> books;
}
