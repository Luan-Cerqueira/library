package dev.luanc.library.model;

import dev.luanc.library.model.enums.LoanStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_loan")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Loan {

    @Id
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "loan_date", nullable = false)
    @Builder.Default
    private LocalDateTime loanDate = LocalDateTime.now();

    @Column(name = "due_date", nullable = false)
    private LocalDateTime dueDate;

    @Column(name = "return_date")
    private LocalDateTime returnDate;

    @Column( nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private LoanStatus status = LoanStatus.ACTIVE;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_copy_id")
    private BookCopy bookCopy;
}
