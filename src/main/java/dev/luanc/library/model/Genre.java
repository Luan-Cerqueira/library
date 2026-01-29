package dev.luanc.library.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    private int id;
    private String name;

    @ManyToMany(mappedBy = "genres", cascade = CascadeType.PERSIST)
    private Set<Book> books;
}
