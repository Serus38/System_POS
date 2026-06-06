package com.system.system_pos.service.User;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.system.system_pos.dto.user.UserRequest;
import com.system.system_pos.dto.user.UserResponse;
import com.system.system_pos.exception.InvalidRoleException;
import com.system.system_pos.exception.ResourceNotFound;
import com.system.system_pos.mapper.UserMapper;
import com.system.system_pos.model.admin.User;
import com.system.system_pos.repository.UserRepository;
import com.system.system_pos.util.SanitizerUtil;

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
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found with id: " + id));
    }

    @Override
    public UserResponse save(UserRequest dto) {
        validateRole(dto.role());

        User user = new User();
        user.setName(SanitizerUtil.capitalizeName(dto.name()));
        user.setUsername(SanitizerUtil.cleanUsername(dto.username()));
        user.setNit(SanitizerUtil.digitsOnly(dto.nit()));
        user.setPassword(passwordEncoder.encode(dto.password()));
        user.setEmail(SanitizerUtil.normalizeEmail(dto.email()));
        user.setRole(dto.role());
        user.setIsActive(true);

        User savedUser = userRepository.save(user);
        return UserMapper.toResponse(savedUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserResponse update(Long id, UserRequest dto) {
        validateRole(dto.role());

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found with id: " + id));

        existingUser.setName(SanitizerUtil.capitalizeName(dto.name()));
        existingUser.setUsername(SanitizerUtil.cleanUsername(dto.username()));
        existingUser.setNit(SanitizerUtil.digitsOnly(dto.nit()));
        existingUser.setEmail(SanitizerUtil.normalizeEmail(dto.email()));
        existingUser.setRole(dto.role());

        if (dto.password() != null && !dto.password().isBlank()) {
            existingUser.setPassword(passwordEncoder.encode(dto.password()));
        }

        User updatedUser = userRepository.save(existingUser);
        return UserMapper.toResponse(updatedUser);
    }

    private void validateRole(Object role) {
        if (role == null) {
            throw new InvalidRoleException("Rol inválido. Los valores permitidos son: ADMIN, EMPLOYEE");
        }
    }
}
