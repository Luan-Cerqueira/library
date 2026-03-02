package dev.luanc.library.dto.loan;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AddLoanRequest(

        @NotBlank(message = "userEmail: Is required")
        String userEmail,

        @NotEmpty(message = "assetTag: Is required")
        String assetTag,

        @JsonFormat(pattern = "dd/MM/yyyy'T'HH:mm:ss")
        LocalDateTime loanDate
) {
}
