package dev.luanc.library.repository;

import dev.luanc.library.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    public List<Loan> findLoanByUserEmail(String email);
}
