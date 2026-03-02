package dev.luanc.library.controller;

import dev.luanc.library.dto.loan.LoanResponse;
import dev.luanc.library.dto.user.RegisterUserRequest;
import dev.luanc.library.dto.user.UserResponse;
import dev.luanc.library.service.LoanService;
import dev.luanc.library.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
@Tag(name = "User", description = "User Controller for user management")
public class UserController {

    private UserService userService;
    private LoanService loanService;

    @GetMapping
    public ResponseEntity<UserResponse> getUserByEmail(@RequestParam String email) {
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestParam String email, @RequestBody RegisterUserRequest userReq) {
        return new ResponseEntity<>(userService.updateUser(email, userReq), HttpStatus.OK);
    }

    @GetMapping({"/me"})
    public ResponseEntity<UserResponse> getMyProfile() {
        String email = getUserEmail();
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping({"/me/loans"})
    public ResponseEntity<List<LoanResponse>> getMyLoans() {
        String email = getUserEmail();
        return new ResponseEntity<>(loanService.getLoanByUserEmail(email), HttpStatus.OK);
    }

    //@GetMapping({"/me/infractions"})

    private String getUserEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
