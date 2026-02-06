package dev.luanc.library.dto.loan;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record UpdateLoanReturnDate(
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate returnDate
) {
}
