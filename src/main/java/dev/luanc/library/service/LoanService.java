package dev.luanc.library.service;

import dev.luanc.library.dto.loan.AddLoanRequest;
import dev.luanc.library.dto.loan.AddLoanResponse;
import dev.luanc.library.dto.loan.LoanToEntity;
import dev.luanc.library.mapper.LoanMapper;
import dev.luanc.library.model.BookCopy;
import dev.luanc.library.model.Loan;
import dev.luanc.library.model.User;
import dev.luanc.library.model.enums.BookCopyStatus;
import dev.luanc.library.model.enums.UserStatus;
import dev.luanc.library.repository.BookCopyRepository;
import dev.luanc.library.repository.LoanRepository;
import dev.luanc.library.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanService {

    private LoanRepository loanRepository;
    private UserRepository userRepository;
    private BookCopyRepository bookCopyRepository;

    public AddLoanResponse addLoan(AddLoanRequest loanReq) {
        User user = userRepository.findUserByEmail(
                loanReq.userEmail()).orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getStatus() != UserStatus.ACTIVE) {
            throw new RuntimeException("User " + user.getStatus());
        }

        BookCopy bc = bookCopyRepository
                .findBookCopyByAssetTag(loanReq.assetTag()).orElseThrow(() -> new RuntimeException("Book copy not found"));

        if (bc.getStatus() != BookCopyStatus.AVAILABLE) {
            throw new RuntimeException("Book copy not available");
        }

        LocalDate loanDate = loanReq.loanDate() != null ? loanReq.loanDate() : LocalDate.now();

        LoanToEntity loan = new LoanToEntity(user, bc, loanDate, loanDate.plusDays(14));
        bc.setStatus(BookCopyStatus.NOT_AVAILABLE);

        return LoanMapper.toResponse(loanRepository.save(LoanMapper.toEntity(loan)));
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public AddLoanResponse getLoanById(Long id) {
        return LoanMapper.toResponse(
                loanRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Loan not found")));
    }
}
