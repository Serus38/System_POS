package com.milcolores.system_pos.service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.milcolores.system_pos.dto.user.UserRequestDto;
import com.milcolores.system_pos.dto.user.UserResponse;
import com.milcolores.system_pos.model.admin.User;

@Service
public interface UserService {

    List<UserResponse> getAllUsers();

    User getUserById(Long id);

    UserResponse save(UserRequestDto dto);

    void delete(Long id);

    UserResponse update(Long id, UserRequestDto dto);
}

