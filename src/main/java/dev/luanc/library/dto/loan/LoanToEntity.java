package dev.luanc.library.dto.loan;

import dev.luanc.library.model.BookCopy;
import dev.luanc.library.model.User;

import java.time.LocalDate;

public record LoanToEntity(
        User user,
        BookCopy bookCopy,
        LocalDate loanDate,
        LocalDate dueDate
) {
}
