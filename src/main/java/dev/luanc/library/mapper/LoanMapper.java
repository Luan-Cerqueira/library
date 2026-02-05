package dev.luanc.library.mapper;

import dev.luanc.library.dto.loan.AddLoanRequest;
import dev.luanc.library.dto.loan.AddLoanResponse;
import dev.luanc.library.dto.loan.LoanToEntity;
import dev.luanc.library.model.Loan;

public class LoanMapper {

    public static Loan toEntity(LoanToEntity loanReq) {
        return Loan.builder()
                .user(loanReq.user())
                .bookCopy(loanReq.bookCopy())
                .loanDate(loanReq.loanDate())
                .dueDate(loanReq.dueDate())
                .build();
    }

    public static AddLoanResponse toResponse(Loan loan) {
        return new AddLoanResponse(loan.getUser(),
                loan.getBookCopy().getAssetTag(),
                loan.getBookCopy().getBook().getTitle(),
                loan.getLoanDate(),
                loan.getDueDate(),
                loan.getStatus());
    }
}
