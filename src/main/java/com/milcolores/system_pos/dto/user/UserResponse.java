package com.milcolores.system_pos.dto.user;

import java.time.LocalDateTime;

import com.milcolores.system_pos.model.enums.Role;

public record UserResponse(
    Long id,
    String name,
    Role role,
    String username,
    String nit,
    String email,
    boolean isActive,
    LocalDateTime lastLoginAt
) {
}
