package dev.luanc.library.dto.loan;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.luanc.library.model.enums.InfractionReason;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UpdateLoan(
        @JsonFormat(pattern = "dd/MM/yyyy'T'HH:mm:ss") LocalDateTime returnDate,
        InfractionReason infractionReason
) {
}
