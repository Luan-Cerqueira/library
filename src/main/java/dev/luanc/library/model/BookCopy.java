package dev.luanc.library.model;


import dev.luanc.library.model.enums.BookCopyStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "book_copy")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCopy {

    @Id
    @Column(name = "book_copy_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "asset_tag", nullable = false, length = 14, unique = true)
    private String assetTag;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private BookCopyStatus status = BookCopyStatus.AVAILABLE;

    @Column(name = "copy_number", columnDefinition = "SMALLINT", nullable = false)
    private Integer copyNumber;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
}
