package dev.luanc.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "tb_genre")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Genre {
    @Id
    @Column(name = "genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    @Column(name = "genre_name", nullable = false, length = 20, unique = true)
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<Book> books;
}
