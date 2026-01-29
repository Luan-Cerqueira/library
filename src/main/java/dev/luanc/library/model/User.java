package dev.luanc.library.model;

import dev.luanc.library.model.enums.UserRole;
import dev.luanc.library.model.enums.UserStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private Long id;
    private String name;
    private String email;
    private String password;
    private String CPF;
    private UserStatus userStatus = UserStatus.ACTIVE;

    @CreationTimestamp
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private UserRole userRole = UserRole.USER;
}
