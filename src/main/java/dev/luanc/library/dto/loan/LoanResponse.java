package dev.luanc.library.dto.loan;

import dev.luanc.library.model.enums.LoanStatus;

import java.time.LocalDate;

public record LoanResponse(
        String userName,
        String userEmail,
        String bookCopy,
        String bookTitle,
        LocalDate loanDate,
        LocalDate dueDate,
        LocalDate returnDate,
        LoanStatus status
) {
}
