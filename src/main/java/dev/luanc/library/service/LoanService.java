package dev.luanc.library.service;

import dev.luanc.library.dto.loan.AddLoanRequest;
import dev.luanc.library.dto.loan.LoanResponse;
import dev.luanc.library.dto.loan.LoanToEntity;
import dev.luanc.library.dto.loan.UpdateLoan;
import dev.luanc.library.mapper.InfractionMapper;
import dev.luanc.library.mapper.LoanMapper;
import dev.luanc.library.model.BookCopy;
import dev.luanc.library.model.Loan;
import dev.luanc.library.model.User;
import dev.luanc.library.model.enums.BookCopyStatus;
import dev.luanc.library.model.enums.LoanStatus;
import dev.luanc.library.model.enums.UserStatus;
import dev.luanc.library.repository.BookCopyRepository;
import dev.luanc.library.repository.InfractionRepository;
import dev.luanc.library.repository.LoanRepository;
import dev.luanc.library.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class LoanService {

    private LoanRepository loanRepository;
    private UserRepository userRepository;
    private BookCopyRepository bookCopyRepository;
    private InfractionRepository infractionRepository;

    public LoanResponse addLoan(AddLoanRequest loanReq) {
        User user = userRepository
                .findUserByEmail(
                        loanReq.userEmail()).orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getStatus() != UserStatus.ACTIVE) {
            throw new RuntimeException("User " + user.getStatus());
        }

        BookCopy bc = bookCopyRepository
                .findBookCopyByAssetTag(
                        loanReq.assetTag()).orElseThrow(() -> new RuntimeException("Book copy not found"));

        if (bc.getStatus() != BookCopyStatus.AVAILABLE) {
            throw new RuntimeException("Book copy not available");
        }

        LocalDateTime loanDate = loanReq.loanDate() != null ? loanReq.loanDate() : LocalDateTime.now();

        LoanToEntity loan = new LoanToEntity(user, bc, loanDate, loanDate.plusDays(14));
        bc.setStatus(BookCopyStatus.NOT_AVAILABLE);

        return LoanMapper.toResponse(loanRepository.save(LoanMapper.toEntity(loan)));
    }

    public List<LoanResponse> getAllLoans() {
        return LoanMapper.toResponseList(loanRepository.findAll());
    }

    public LoanResponse getLoanById(Integer id) {
        return LoanMapper.toResponse(
                loanRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Loan not found")));
    }

    @Transactional
    public LoanResponse updateLoanById(Integer id, UpdateLoan updateLoan) {
        Loan loan = loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));

        if (loan.getStatus() == LoanStatus.RETURNED) {
            throw new RuntimeException("Loan already returned");
        }

        if (updateLoan.infractionReason() != null) {
            infractionRepository.save(InfractionMapper.toEntity(
                            loan.getUser(),
                            loan,
                            updateLoan.returnDate(),
                            updateLoan.infractionReason())
            );
        }

        if (updateLoan.infractionReason() != null){
            switch (updateLoan.infractionReason()){
                case OVERDUE: loan.getBookCopy().setStatus(BookCopyStatus.AVAILABLE); break;
                case LOST: loan.getBookCopy().setStatus(BookCopyStatus.NOT_AVAILABLE); break;
                case DAMAGED: loan.getBookCopy().setStatus(BookCopyStatus.DAMAGED); break;
            }
        }

        if(infractionRepository.countInfractionByUser(loan.getUser()) >= 3){
            loan.getUser().setStatus(UserStatus.BLOCKED);
        }

        loan.setReturnDate(updateLoan.returnDate());
        loan.setStatus(LoanStatus.RETURNED);


        return LoanMapper.toResponse(loanRepository.save(loan));
    }

    public List<LoanResponse> getLoanByUserEmail(String email){
        return LoanMapper.toResponseList(loanRepository.findLoanByUserEmail(email));
    }
}
