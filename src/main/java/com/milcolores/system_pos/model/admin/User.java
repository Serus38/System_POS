package com.milcolores.system_pos.model.admin;

import com.milcolores.system_pos.model.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false, length = 50)
    private String name;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false, length = 20, unique = true)
    private String nit;

    @NotBlank
    @Column(nullable = false, length = 20, unique = true)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    @Email
    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(columnDefinition = "boolean default true", nullable = false)
    private Boolean isActive = true;

    @Column
    private LocalDateTime lastLoginAt;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public User(Long id, @NotBlank String name, @NotBlank Role role, String nit, @NotBlank String username, @Email String email, String password) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.nit = nit;
        this.username = username;
        this.password = password;
        this.email = email;
        this.isActive = true;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
