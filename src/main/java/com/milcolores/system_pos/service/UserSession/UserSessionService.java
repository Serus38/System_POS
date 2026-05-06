package com.milcolores.system_pos.service.UserSession;

import java.util.List;

import org.springframework.stereotype.Service;

import com.milcolores.system_pos.model.admin.UserSession;

@Service
public interface UserSessionService {

    List<UserSession> getAllUserSessions();

    UserSession getUserSessionById(Long id);

    UserSession save(UserSession userSession);

    void delete(Long id);

    UserSession update(UserSession userSession);
}
