package com.milcolores.system_pos.service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.milcolores.system_pos.model.admin.User;

@Service
public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);

    User save(User user);

    void delete(Long id);

    User update(User user);
}
