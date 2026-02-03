package dev.luanc.library.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "tb_author")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Author {

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "author_name", nullable = false, unique = true)
    private String name;

    @Column(name = "nacionality", nullable = false, length = 100)
    private String nacionality;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private Set<Book> books;
}
