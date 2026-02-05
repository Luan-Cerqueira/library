package dev.luanc.library.service;

import dev.luanc.library.dto.user.UserRequest;
import dev.luanc.library.dto.user.UserResponse;
import dev.luanc.library.mapper.UserMapper;
import dev.luanc.library.model.User;
import dev.luanc.library.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public UserResponse addUser(UserRequest userReq) {
        if (userRepository.existsUserByEmail(userReq.email())) {
            throw new RuntimeException("Email already in use");
        }
        // change plaintext password
        User user = userRepository.save(UserMapper.toEntity(userReq));

        return UserMapper.toResponse(user);
    }

    public UserResponse getUserByEmail(String email) {
        return UserMapper.toResponse(userRepository
                .findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found")));
    }

    public UserResponse updateUser(String email, UserRequest userReq) {
        User updatedUser = userRepository.findUserByEmail(
                email).orElseThrow(() -> new RuntimeException("User not found"));
        updatedUser.setName(userReq.name() != null ? userReq.name() : updatedUser.getName());
        updatedUser.setEmail(userReq.email() != null ? userReq.email() : updatedUser.getEmail());
        updatedUser.setPassword(userReq.password() != null ? userReq.password() : updatedUser.getPassword());


        return UserMapper.toResponse(userRepository.save(updatedUser));
    }
}
