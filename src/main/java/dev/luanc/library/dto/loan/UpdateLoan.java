package dev.luanc.library.dto.loan;

import com.fasterxml.jackson.annotation.JsonFormat;
import dev.luanc.library.model.enums.InfractionReason;

import java.time.LocalDate;

public record UpdateLoan(
        @JsonFormat(pattern = "dd/MM/yyyy") LocalDate returnDate,
        InfractionReason infractionReason
) {
}
