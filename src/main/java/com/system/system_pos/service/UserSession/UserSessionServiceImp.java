package com.system.system_pos.service.UserSession;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.system_pos.exception.ResourceNotFound;
import com.system.system_pos.model.admin.UserSession;
import com.system.system_pos.repository.UserSessionRepository;

@Service
public class UserSessionServiceImp implements UserSessionService {

    private final UserSessionRepository userSessionRepository;

    public UserSessionServiceImp(UserSessionRepository userSessionRepository) {
        this.userSessionRepository = userSessionRepository;
    }

    @Override
    public List<UserSession> getAllUserSessions() {
        return userSessionRepository.findAll();
    }

    @Override
    public UserSession getUserSessionById(Long id) {
        UserSession userSession = userSessionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("UserSession not found with id: " + id));
        return userSession;
    }

    @Override
    public UserSession save(UserSession userSession) {
        return userSessionRepository.save(userSession);
    }

    @Override
    public void delete(Long id) {
        userSessionRepository.deleteById(id);
    }

    @Override
    public UserSession update(UserSession userSession) {
        return userSessionRepository.save(userSession);
    }
}
