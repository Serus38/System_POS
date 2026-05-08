package com.milcolores.system_pos.mapper;

import com.milcolores.system_pos.dto.user.UserRequest;
import com.milcolores.system_pos.dto.user.UserResponse;
import com.milcolores.system_pos.model.admin.User;

public class UserMapper {

    public static User toEntity(UserRequest dto) {
        User user = new User();
        user.setName(dto.name());
        user.setUsername(dto.username());
        user.setNit(dto.nit());
        user.setPassword(dto.password());
        user.setEmail(dto.email());
        user.setRole(dto.role());
        user.setIsActive(true);
        return user;
    }

    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getRole(),
                user.getUsername(),
                user.getNit(),
                user.getEmail(),
                user.getIsActive(),
                user.getLastLoginAt()
        );
    }
}
