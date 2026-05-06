package com.milcolores.system_pos.service.User;

import java.util.List;

import org.springframework.stereotype.Service;

import com.milcolores.system_pos.exception.ResourceNotFound;
import com.milcolores.system_pos.model.admin.User;
import com.milcolores.system_pos.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("User not found with id: " + id));
        return user;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        return userRepository.save(user);
    }
}
