package dev.luanc.library.repository;

import dev.luanc.library.model.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookCopyRepository extends JpaRepository<BookCopy, Integer> {

    @Query(value = "SELECT MAX(CAST(SUBSTR(asset_tag, 10, 5) AS INTEGER))" +
            "FROM book_copy WHERE asset_tag LIKE %:year%", nativeQuery = true)
    Integer findLastSequenceByYear(@Param("year") int year);

    @Query(value = "SELECT MAX(bc.copyNumber) FROM BookCopy bc WHERE bc.book.title = :title")
    Short findLastCopyNumberByTitle(String title);

    List<BookCopy> getBookCopyByBookId(Integer id);

    Optional<BookCopy> findBookCopyByAssetTag(String assetTag);
}
