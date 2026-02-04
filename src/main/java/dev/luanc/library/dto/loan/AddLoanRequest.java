package dev.luanc.library.dto.loan;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record AddLoanRequest(
        String userEmail,
        String assetTag,
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate loanDate
) {
}
