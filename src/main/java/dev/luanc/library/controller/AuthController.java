package dev.luanc.library.controller;

import dev.luanc.library.config.security.TokenConfig;
import dev.luanc.library.dto.user.LoginRequest;
import dev.luanc.library.dto.user.LoginResponse;
import dev.luanc.library.dto.user.RegisterUserRequest;
import dev.luanc.library.dto.user.UserResponse;
import dev.luanc.library.model.User;
import dev.luanc.library.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
@Tag(name = "Auth", description = "Authentication Controller for user registration and login")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginReq) {

        UsernamePasswordAuthenticationToken userAndPass = new UsernamePasswordAuthenticationToken(loginReq.email(), loginReq.password());
        Authentication authentication = authenticationManager.authenticate(userAndPass);

        User user = (User) authentication.getPrincipal();
        String token = tokenConfig.generateToken(user);

        return new ResponseEntity<>(new LoginResponse(token), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterUserRequest registerUserReq) {
        return new ResponseEntity<>(userService.addUser(registerUserReq), HttpStatus.CREATED);
    }
}
