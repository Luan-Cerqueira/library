package dev.luanc.library.dto.loan;

import dev.luanc.library.model.enums.LoanStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record LoanResponse(
        String userName,
        String userEmail,
        String bookCopy,
        String bookTitle,
        LocalDateTime loanDate,
        LocalDateTime dueDate,
        LocalDateTime returnDate,
        LoanStatus status
) {
}
