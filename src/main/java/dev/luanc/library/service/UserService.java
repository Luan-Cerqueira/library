package dev.luanc.library.service;

import dev.luanc.library.dto.user.RegisterUserRequest;
import dev.luanc.library.dto.user.UserResponse;
import dev.luanc.library.mapper.UserMapper;
import dev.luanc.library.model.User;
import dev.luanc.library.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserResponse addUser(RegisterUserRequest userReq) {
        if (userRepository.existsUserByEmail(userReq.email())) {
            throw new RuntimeException("Email already in use");
        }

        User user = UserMapper.toEntity(userReq);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return UserMapper.toResponse(userRepository.save(user));
    }

    public UserResponse getUserByEmail(String email) {
        return UserMapper.toResponse(userRepository
                .findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(String email, RegisterUserRequest userReq) {
        User updatedUser = userRepository.findUserByEmail(
                email).orElseThrow(() -> new RuntimeException("User not found"));
        updatedUser.setName(userReq.name() != null ? userReq.name() : updatedUser.getName());
        updatedUser.setEmail(userReq.email() != null ? userReq.email() : updatedUser.getEmail());
        updatedUser.setPassword(userReq.password() != null ? userReq.password() : updatedUser.getPassword());


        return UserMapper.toResponse(userRepository.save(updatedUser));
    }
}
