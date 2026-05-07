package com.milcolores.system_pos.service.User;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.milcolores.system_pos.dto.user.UserRequest;
import com.milcolores.system_pos.dto.user.UserResponse;
import com.milcolores.system_pos.exception.ResourceNotFound;
import com.milcolores.system_pos.model.admin.User;
import com.milcolores.system_pos.repository.UserRepository;
import com.milcolores.system_pos.util.TextFormatter;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found with id: " + id));
        return user;
    }

    @Override
    public UserResponse save(UserRequest dto) {
        User user = new User();
        user.setName(TextFormatter.formatName(dto.name()));
        user.setUsername(TextFormatter.cleanUsername(dto.username()));
        user.setNit(TextFormatter.cleanIdentifier(dto.nit()));
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setEmail(dto.email().toLowerCase().trim());
        user.setRole(dto.role());
        user.setIsActive(true);
        User savedUser = userRepository.save(user);
        return mapToResponse(savedUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse update(Long id, UserRequest dto) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found with id: " + id));
        existingUser.setName(TextFormatter.formatName(dto.name()));
        existingUser.setUsername(TextFormatter.cleanUsername(dto.username()));
        existingUser.setNit(TextFormatter.cleanIdentifier(dto.nit()));
        existingUser.setEmail(dto.email().toLowerCase().trim());
        existingUser.setRole(dto.role());
        if (dto.password() != null && !dto.password().isBlank()) {
            existingUser.setPassword(passwordEncoder.encode(dto.password()));
        }
        return mapToResponse(userRepository.save(existingUser));
    }

    private UserResponse mapToResponse(User user) {
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
