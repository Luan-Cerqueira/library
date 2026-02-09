package dev.luanc.library.mapper;

import dev.luanc.library.dto.user.RegisterUserRequest;
import dev.luanc.library.dto.user.UserResponse;
import dev.luanc.library.model.User;

public class UserMapper {

    public static User toEntity(RegisterUserRequest userReq){
        return User.builder()
                .name(userReq.name())
                .email(userReq.email())
                .CPF(userReq.CPF())
                .password(userReq.password())
                .build();
    }

    public static UserResponse toResponse(User user){
        return new UserResponse(
                user.getName(),
                user.getEmail()
        );
    }
}
