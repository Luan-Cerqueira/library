package dev.luanc.library.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_publisher")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    @EqualsAndHashCode.Include
    private Integer id;

    @Column(name = "publisher_name", nullable = false, length = 120, unique = true)
    private String name;

    @Column(nullable = false, length = 60)
    private String country;
}
