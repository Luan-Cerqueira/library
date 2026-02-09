package dev.luanc.library.mapper;

import dev.luanc.library.dto.loan.LoanResponse;
import dev.luanc.library.dto.loan.LoanToEntity;
import dev.luanc.library.model.Loan;

import java.util.List;

public class LoanMapper {

    public static Loan toEntity(LoanToEntity loanReq) {
        return Loan.builder()
                .user(loanReq.user())
                .bookCopy(loanReq.bookCopy())
                .loanDate(loanReq.loanDate())
                .dueDate(loanReq.dueDate())
                .build();
    }

    public static LoanResponse toResponse(Loan loan) {
        return new LoanResponse(loan.getUser().getName(),
                loan.getUser().getEmail(),
                loan.getBookCopy().getAssetTag(),
                loan.getBookCopy().getBook().getTitle(),
                loan.getLoanDate(),
                loan.getDueDate(),
                loan.getReturnDate(),
                loan.getStatus());
    }

    public static List<LoanResponse> toResponseList(List<Loan> loans){
        return loans.stream()
                .map(LoanMapper::toResponse)
                .toList();
    }
}
