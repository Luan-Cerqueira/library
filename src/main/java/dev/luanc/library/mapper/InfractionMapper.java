package dev.luanc.library.mapper;

import dev.luanc.library.model.Infraction;
import dev.luanc.library.model.Loan;
import dev.luanc.library.model.User;
import dev.luanc.library.model.enums.InfractionReason;

import java.time.LocalDate;

public class InfractionMapper {
    public static Infraction toEntity(User user, Loan loan, LocalDate occurrence_date, InfractionReason infractionReason){
        return Infraction.builder()
                .user(user)
                .loan(loan)
                .occurrence_date(occurrence_date)
                .reason(infractionReason)
                .build();
    }
}
