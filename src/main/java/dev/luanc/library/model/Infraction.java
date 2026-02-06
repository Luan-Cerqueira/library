package dev.luanc.library.model;


import dev.luanc.library.model.enums.InfractionReason;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tb_infraction")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Infraction {

    @Id
    @Column(name = "infraction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "occurrence_date", nullable = false)
    private LocalDate occurrence_date = LocalDate.now();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private InfractionReason reason;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
