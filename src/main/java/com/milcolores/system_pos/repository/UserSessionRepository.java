package com.milcolores.system_pos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.milcolores.system_pos.model.admin.UserSession;

@Repository
public interface UserSessionRepository extends JpaRepository<UserSession, Long> {
    
}
