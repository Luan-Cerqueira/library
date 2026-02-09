package dev.luanc.library.controller;

import dev.luanc.library.dto.user.RegisterUserRequest;
import dev.luanc.library.dto.user.UserResponse;
import dev.luanc.library.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody RegisterUserRequest userReq) {
        return new ResponseEntity<>(userService.addUser(userReq), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<UserResponse> getUserByEmail(@RequestParam String email){
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserResponse> updateUser(@RequestParam String email, @RequestBody RegisterUserRequest userReq) {
        return new ResponseEntity<>(userService.updateUser(email, userReq), HttpStatus.OK);
    }

}
