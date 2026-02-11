package dev.luanc.library.dto.loan;

import dev.luanc.library.model.BookCopy;
import dev.luanc.library.model.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record LoanToEntity(
        User user,
        BookCopy bookCopy,
        LocalDateTime loanDate,
        LocalDateTime dueDate
) {
}
