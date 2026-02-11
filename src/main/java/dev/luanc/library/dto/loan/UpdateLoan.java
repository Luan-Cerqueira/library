package dev.luanc.library.dto.loan;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.luanc.library.model.enums.InfractionReason;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UpdateLoan(
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDateTime returnDate,
        InfractionReason infractionReason
) {
}
