package dev.luanc.library.model;


import dev.luanc.library.model.enums.BookCopyStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookCopy {

    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
    private String assetTag;
    private BookCopyStatus status = BookCopyStatus.AVAILABLE;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
