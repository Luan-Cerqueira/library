package dev.luanc.library.controller;

import dev.luanc.library.dto.loan.AddLoanRequest;
import dev.luanc.library.dto.loan.LoanResponse;
import dev.luanc.library.dto.loan.UpdateLoan;
import dev.luanc.library.service.LoanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/loans")
@AllArgsConstructor
@Tag(name = "Loan", description = "Loan Controller for loan management")
public class LoanController {
    private LoanService loanService;

    @PostMapping
    public ResponseEntity<LoanResponse> addLoan(@Valid @RequestBody AddLoanRequest loanReq) {
        return new ResponseEntity<>(loanService.addLoan(loanReq), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LoanResponse>> getAllLoans() {
        return new ResponseEntity<>(loanService.getAllLoans(), HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<LoanResponse> getLoanById(@PathVariable Integer id) {
        return new ResponseEntity<>(loanService.getLoanById(id), HttpStatus.OK);
    }

    @PatchMapping({"/{id}/return"})
    public ResponseEntity<LoanResponse> updateLoanById(@PathVariable Integer id,
                                                       @RequestBody UpdateLoan updateLoanReq) {

        return new ResponseEntity<>(loanService.updateLoanById(id, updateLoanReq), HttpStatus.OK);
    }
}
