package dev.luanc.library.dto.loan;

import dev.luanc.library.model.BookCopy;
import dev.luanc.library.model.User;
import dev.luanc.library.model.enums.LoanStatus;

import java.time.LocalDate;

public record AddLoanResponse(
        User user,
        BookCopy bookCopy,
        String bookTitle,
        LocalDate loanDate,
        LocalDate dueDate,
        LoanStatus status
) {
}
