package dev.luanc.library.repository;

import dev.luanc.library.model.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {

    @Query(value = "SELECT MAX(CAST(SUBSTR(asset_tag, 10, 5) AS INTEGER))" +
                    "FROM book_copy WHERE asset_tag LIKE %:year%", nativeQuery = true)
    Integer findLastSequenceByYear(@Param("year") int year);

    @Query(value = "SELECT MAX(bc.copyNumber) FROM BookCopy bc WHERE bc.book.title = :title")
    Integer findLastCopyNumberByTitle(String title);
}
