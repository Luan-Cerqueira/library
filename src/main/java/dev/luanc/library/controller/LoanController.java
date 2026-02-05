package dev.luanc.library.controller;

import dev.luanc.library.dto.loan.AddLoanRequest;
import dev.luanc.library.dto.loan.AddLoanResponse;
import dev.luanc.library.model.Loan;
import dev.luanc.library.service.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@AllArgsConstructor
public class LoanController {
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<AddLoanResponse> addLoan(@RequestBody AddLoanRequest loanReq) {
        return new ResponseEntity<>(loanService.addLoan(loanReq), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllLoans() {
        return new ResponseEntity<>(loanService.getAllLoans(), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<AddLoanResponse> getLoanById(@PathVariable Long id) {
        return new ResponseEntity<>(loanService.getLoanById(id), HttpStatus.OK);
    }
}
